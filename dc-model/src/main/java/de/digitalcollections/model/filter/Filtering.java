package de.digitalcollections.model.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/** Container for a list of {@link FilterCriterion}s */
public class Filtering {

  public static Builder builder() {
    return new Builder();
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

  public void add(FilterCriterion filterCriterion) {
    if (filterCriteria == null) {
      filterCriteria = new ArrayList<>();
    }
    filterCriteria.add(filterCriterion);
  }

  public void add(String expression, FilterCriterion filterCriterion) {
    if (filterCriterion == null || expression == null) {
      return;
    }

    FilterCriterion filterCriterionWithExpression = new FilterCriterion(filterCriterion);
    filterCriterionWithExpression.setExpression(expression);

    filterCriteria.add(filterCriterionWithExpression);
  }

  /**
   * @return returns all filter criterias
   */
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

  /**
   * @param filterCriteria set list of filter criteria
   */
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
    return Objects.hash(filterCriteria) + Objects.hash("Filtering");
  }

  @Override
  public String toString() {
    return "Filtering{" + "filterCriteria=" + filterCriteria + '}';
  }

  /**
   * Filtering filtering = Filtering.defaultBuilder() .filter("publicationStart").lessOrEqual(now)
   * .filter("publicationEnd").greaterOrEqual(now) .build();
   */
  public static class Builder {

    private final List<FilterCriterion> filterCriterias = new ArrayList<>();

    /**
     * Method needed for mapping URL filter param to a filter criterion. only param value available
     * during controller, so param name (= expression) only can be set after mapping.
     *
     * <p>adds a filter criterion to list of filter criterias. if given filterCriterion is null, no
     * filter criterion is added (null-safe)
     *
     * @param expression name of expression (if expression name could not be set during
     *     instantiation of FieldCriterion, e.g. during spring mvc type conversion)
     * @param filterCriterion filter criterion to add
     * @return builder instance for fluent usage
     */
    public Builder add(String expression, FilterCriterion filterCriterion) {
      if (filterCriterion != null) {
        filterCriterion.setExpression(expression);
      }
      return add(filterCriterion);
    }

    /**
     * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no
     * filter criteria is added (null-safe)
     *
     * @param filterCriterion filter criteria to add
     * @return builder instance for fluent usage
     */
    public Builder add(FilterCriterion filterCriterion) {
      if (filterCriterion != null) {
        if (filterCriterion.getExpression() == null) {
          throw new IllegalArgumentException("expression of a filter criterion must not be null!");
        }
        filterCriterias.add(filterCriterion);
      }
      return this;
    }

    public Filtering build() {
      return new Filtering(filterCriterias);
    }
  }
}
