package de.digitalcollections.model.list;

import de.digitalcollections.model.filter.FilterCriterion;
import de.digitalcollections.model.filter.Filtering;
import de.digitalcollections.model.paging.Direction;
import de.digitalcollections.model.paging.Sorting;
import java.io.Serializable;
import java.util.List;

/**
 * Container for querying a optionally filtered and sorted list:
 *
 * <ul>
 *   <li>filtering: container for filter criterias of result list
 *   <li>sorting: container for sorting order of result list
 * </ul>
 */
public class ListRequest implements Serializable {

  protected Filtering filtering;
  protected Sorting sorting;

  public ListRequest() {}

  /**
   * Creates a new {@link ListRequest} with sorting parameters applied.
   *
   * @param direction the direction of the {@link Sorting} to be specified, can be {@literal null}.
   * @param properties the properties to sorting by, must not be {@literal null} or empty.
   */
  public ListRequest(Direction direction, String... properties) {
    this(new Sorting(direction, properties), null);
  }

  public ListRequest(Sorting sorting) {
    this(sorting, null);
  }

  /**
   * Creates a new {@link ListRequest} with sorting parameters applied.
   *
   * @param sorting can be {@literal null}
   * @param filtering contains list of filter criterias
   */
  public ListRequest(Sorting sorting, Filtering filtering) {
    this.filtering = filtering;
    this.sorting = sorting;
  }

  /**
   * Add all filter criteria of given filtering to existing filtering. Initialise if no existing
   * filtering.
   *
   * @param filtering new filtering criteria to add
   * @return all filtering criteria
   */
  public List<FilterCriterion> add(Filtering filtering) {
    Filtering existingFiltering = getFiltering();
    if (existingFiltering == null || existingFiltering.getFilterCriteria().isEmpty()) {
      setFiltering(filtering);
    } else {
      existingFiltering.add(filtering);
    }
    // FIXME (breaking change): return this?
    return getFiltering().getFilterCriteria();
  }

  /**
   * Add all sorting criteria of given sorting to existing sorting. Initialise if no existing
   * filtering.
   *
   * @param sorting new sorting criteria to add
   * @return all sorting criteria
   */
  public ListRequest add(Sorting sorting) {
    Sorting existingSorting = getSorting();
    if (existingSorting == null || existingSorting.getOrders().isEmpty()) {
      setSorting(sorting);
    } else {
      existingSorting.and(sorting);
    }
    return this;
  }

  @Override
  public boolean equals(final Object obj) {

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof ListRequest)) {
      return false;
    }

    ListRequest that = (ListRequest) obj;

    boolean filterEqual =
        (this.filtering == null ? that.filtering == null : this.filtering.equals(that.filtering));
    boolean sortEqual =
        (this.sorting == null ? that.sorting == null : this.sorting.equals(that.sorting));
    return filterEqual && sortEqual;
  }

  /** @return the filtering parameters */
  public Filtering getFiltering() {
    return filtering;
  }

  /** @return the sorting parameters */
  public Sorting getSorting() {
    return sorting;
  }

  /** @return whether the request has defined any filtering. */
  public boolean hasFiltering() {
    return filtering != null
        && filtering.getFilterCriteria() != null
        && !filtering.getFilterCriteria().isEmpty();
  }

  /** @return whether the request has defined any sorting. */
  public boolean hasSorting() {
    return sorting != null && sorting.getOrders() != null && !sorting.getOrders().isEmpty();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;

    return prime * result
        + (null == sorting ? 0 : sorting.hashCode())
        + (null == filtering ? 0 : filtering.hashCode());
  }

  /** @param filtering the filtering criterias */
  public void setFiltering(Filtering filtering) {
    this.filtering = filtering;
  }

  /** @param sorting the sorting parameters */
  public void setSorting(Sorting sorting) {
    this.sorting = sorting;
  }

  @Override
  public String toString() {
    return String.format(
        "List request [sorting: %s, filtering: %s]",
        sorting == null ? null : sorting.toString(),
        filtering == null ? null : filtering.toString());
  }
}
