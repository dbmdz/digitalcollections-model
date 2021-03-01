package de.digitalcollections.model.paging;

import de.digitalcollections.model.filter.FilterCriterion;
import de.digitalcollections.model.filter.Filtering;
import java.io.Serializable;
import java.util.List;

/**
 * Basic Java Bean implementation of {@code PageRequest}. See Spring Data Commons, but more flat
 * design and independent of Spring libraries.
 *
 * <p>Container for paging, sorting and filtering params:
 *
 * <ul>
 *   <li>pageNumber: which page to be returned
 *   <li>pageSize: how many items on one page
 *   <li>sorting: container for sorting order of result list
 *   <li>filtering: container for filter criterias of result list
 * </ul>
 */
public class PageRequest implements Serializable {

  public static PageRequestBuilder defaultBuilder() {
    return new PageRequestBuilder();
  }

  private Filtering filtering;
  private int pageNumber;
  private int pageSize;
  private Sorting sort;

  public PageRequest() {}

  /**
   * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing 0 for {@code page}
   * will return the first page.
   *
   * @param pageNumber zero-based page index.
   * @param pageSize the size of the page to be returned.
   */
  public PageRequest(int pageNumber, int pageSize) {
    this(pageNumber, pageSize, null, (Filtering) null);
  }

  /**
   * Creates a new {@link PageRequest} with sort parameters applied.
   *
   * @param pageNumber zero-based page index.
   * @param pageSize the size of the page to be returned.
   * @param direction the direction of the {@link Sorting} to be specified, can be {@literal null}.
   * @param properties the properties to sort by, must not be {@literal null} or empty.
   */
  public PageRequest(int pageNumber, int pageSize, Direction direction, String... properties) {
    this(pageNumber, pageSize, new Sorting(direction, properties), null);
  }

  public PageRequest(int pageNumber, int pageSize, Sorting sort) {
    this(pageNumber, pageSize, sort, null);
  }

  /**
   * Creates a new {@link PageRequest} with sort parameters applied.
   *
   * @param pageNumber zero-based page index, must not be less than zero.
   * @param pageSize the size of the page to be returned, must not be less than one.
   * @param sort can be {@literal null}
   * @param filtering contains list of filter criterias
   */
  public PageRequest(int pageNumber, int pageSize, Sorting sort, Filtering filtering) {
    if (pageNumber < 0) {
      throw new IllegalArgumentException("Page index must not be less than zero!");
    }

    if (pageSize < 1) {
      throw new IllegalArgumentException("Page size must not be less than one!");
    }

    this.filtering = filtering;
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
    this.sort = sort;
  }

  /**
   * Add all filter criteria of given filtering to existing filtering. Initialise if no existing
   * filtering.
   *
   * @param filtering new filtering criteria to add
   * @return complete filtering
   */
  public List<FilterCriterion> add(Filtering filtering) {
    Filtering existingFiltering = getFiltering();
    if (existingFiltering == null || existingFiltering.getFilterCriteria().isEmpty()) {
      setFiltering(filtering);
    } else {
      existingFiltering.add(filtering);
    }
    return getFiltering().getFilterCriteria();
  }

  @Override
  public boolean equals(final Object obj) {

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof PageRequest)) {
      return false;
    }

    PageRequest that = (PageRequest) obj;

    boolean filterEqual =
        (this.filtering == null ? that.filtering == null : this.filtering.equals(that.filtering));
    boolean sortEqual = (this.sort == null ? that.sort == null : this.sort.equals(that.sort));
    boolean othersEqual = (this.pageNumber == that.pageNumber && this.pageSize == that.pageSize);

    return filterEqual && othersEqual && sortEqual;
  }

  /** @return the {@link PageRequest} requesting the first page */
  public PageRequest first() {
    return new PageRequest(0, getPageSize(), getSorting(), getFiltering());
  }

  /** @return the filtering parameters */
  public Filtering getFiltering() {
    return filtering;
  }

  /** @return the offset to be taken according to the underlying page and page size. */
  public int getOffset() {
    return pageNumber * pageSize;
  }

  /** @return the page to be returned. */
  public int getPageNumber() {
    return pageNumber;
  }

  /** @return the number of items of that page */
  public int getPageSize() {
    return pageSize;
  }

  /** @return the sorting parameters */
  public Sorting getSorting() {
    return sort;
  }

  /**
   * Returns whether there's a previous {@link PageRequest} we can access from the current one. Will
   * return {@literal false} in case the current {@link PageRequest} already refers to the first
   * page.
   *
   * @return whether there's a previous PageRequest
   */
  public boolean hasPrevious() {
    return pageNumber > 0;
  }

  /** @return whether the page request has defined any sorting. */
  public boolean hasSorting() {
    return !(sort == null || sort.getOrders() == null || sort.getOrders().isEmpty());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + pageNumber;
    result = prime * result + pageSize;

    return 31 * result + (null == sort ? 0 : sort.hashCode());
  }

  /** @return the {@link PageRequest} requesting the next page */
  public PageRequest next() {
    return new PageRequest(getPageNumber() + 1, getPageSize(), getSorting());
  }

  /**
   * Returns the {@link PageResponse} requesting the previous page.
   *
   * @return the PageResponse requesting the previous page
   */
  public PageRequest previous() {
    return getPageNumber() == 0
        ? this
        : new PageRequest(getPageNumber() - 1, getPageSize(), getSorting());
  }

  /**
   * @return the previous {@link PageRequest} or the first {@link PageRequest} if the current one
   *     already is the first one
   */
  public PageRequest previousOrFirst() {
    return hasPrevious() ? previous() : first();
  }

  /** @param filtering the filtering criterias */
  public void setFiltering(Filtering filtering) {
    this.filtering = filtering;
  }

  /** @param pageNumber the page to be returned */
  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  /** @param pageSize the number of items of that page */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /** @param sorting the sorting parameters */
  public void setSorting(Sorting sorting) {
    this.sort = sorting;
  }

  @Override
  public String toString() {
    return String.format(
        "Page request [number: %d, size %d, sort: %s, filtering: %s]",
        getPageNumber(),
        getPageSize(),
        sort == null ? null : sort.toString(),
        filtering == null ? null : filtering.toString());
  }
}
