package de.digitalcollections.model.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/** Container for a list of {@link FilterCriterion}s */
public class Filtering {

  public static FilteringBuilder defaultBuilder() {
    return new FilteringBuilder();
  }

  private List<FilterCriterion> filterCriteria = new ArrayList<>();

  public Filtering() {}

  public Filtering(List<FilterCriterion> filterCriteria) {
    this.filterCriteria = filterCriteria;
  }

  /**
   * Add all filter criteria of given filtering to existing filtering. Initialise if no existing
   * filtering.
   *
   * @param filtering new filtering to add
   * @return complete filtering
   */
  public List<FilterCriterion> add(Filtering filtering) {
    if (filtering == null || filtering.getFilterCriteria() == null) {
      return getFilterCriteria();
    }
    if (getFilterCriteria() == null) {
      setFilterCriteria(filtering.getFilterCriteria());
      return getFilterCriteria();
    }
    List<FilterCriterion> mergedList = new ArrayList<>(getFilterCriteria());
    mergedList.addAll(filtering.getFilterCriteria());
    setFilterCriteria(mergedList);
    return getFilterCriteria();
  }

  /** @return returns all filter criterias */
  public List<FilterCriterion> getFilterCriteria() {
    return filterCriteria;
  }

  /**
   * Returns the filter criteria registered for the given property.
   *
   * @param property given property
   * @return the filter criteria registered for the given property
   */
  public FilterCriterion getFilterCriterionFor(String property) {
    return filterCriteria.stream()
        .filter(f -> f.getExpression().equals(property))
        .findFirst()
        .orElse(null);
  }

  public Iterator<FilterCriterion> iterator() {
    return filterCriteria.iterator();
  }

  /** @param filterCriteria set list of filter criteria */
  public void setFilterCriteria(List<FilterCriterion> filterCriteria) {
    this.filterCriteria = filterCriteria;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Filtering)) {
      return false;
    }
    Filtering filtering = (Filtering) o;
    return Objects.equals(filterCriteria, filtering.filterCriteria);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filterCriteria);
  }

  @Override
  public String toString() {
    return "Filtering{" + "filterCriteria=" + filterCriteria + '}';
  }
}
