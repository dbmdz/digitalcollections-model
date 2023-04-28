package de.digitalcollections.model.list.filtering;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

/**
 * Contains all {@link FilterCriteria} lists for a filtering. The single lists are logically linked
 * by AND.
 */
@SuperBuilder(buildMethodName = "prebuild")
public class Filtering {

  //  public static Builder builder() {
  //    return new Builder();
  //  }

  @Singular("filterCriteria")
  private List<FilterCriteria> filterCriteriaList;

  public Filtering() {
    init();
  }

  /**
   * Constructs a Filtering with an AND-linked {@link FilterCriteria}.
   *
   * <p>For backwards compatibility only.
   *
   * @param filterCriteria
   */
  @Deprecated
  public Filtering(List<FilterCriterion<?>> filterCriteria) {
    this();
    this.filterCriteriaList.add(new FilterCriteria(filterCriteria));
  }

  /**
   * Add all filter criteria of given filtering to existing filtering. Initialise if no existing
   * filtering.
   *
   * @param filtering new filtering to add
   * @return complete filtering
   */
  public List<FilterCriteria> add(Filtering filtering) {
    if (filtering == null || filtering.getFilterCriteriaList() == null) {
      return getFilterCriteriaList();
    }
    if (getFilterCriteriaList() == null) {
      setFilterCriteriaList(filtering.getFilterCriteriaList());
      return getFilterCriteriaList();
    }
    getFilterCriteriaList().addAll(filtering.getFilterCriteriaList());
    return getFilterCriteriaList();
  }

  /**
   * Adds a {@link FilterCriterion} to the first AND-linked {@link FilterCriteria}.
   *
   * @param filterCriterion
   */
  public void add(FilterCriterion filterCriterion) {
    add(FilterLogicalOperator.AND, List.of(filterCriterion));
  }

  /**
   * Adds the {@code filterCriterions} to the first found {@link FilterCriteria} list with the
   * specified {@code criteriaLink} or adds a new one.
   *
   * @param criteriaLink the logical link of the {@link FilterCriteria} that should be extended or
   *     newly created
   * @param filterCriterions criterions to add
   */
  public void add(FilterLogicalOperator criteriaLink, List<FilterCriterion<?>> filterCriterions) {
    if (filterCriteriaList.isEmpty()) {
      filterCriteriaList.add(new FilterCriteria(criteriaLink, filterCriterions));
      return;
    }
    filterCriteriaList.stream()
        .filter(fc -> fc.getCriterionLink() == criteriaLink)
        .findFirst()
        .ifPresentOrElse(
            fc -> fc.addAll(filterCriterions),
            () -> filterCriteriaList.add(new FilterCriteria(filterCriterions)));
  }

  /**
   * Set the {@code expression} and add the {@link FilterCriterion} to the first AND-linked {@link
   * FilterCriteria}.
   */
  public void add(String expression, FilterCriterion filterCriterion) {
    if (filterCriterion == null || expression == null) {
      return;
    }

    FilterCriterion<?> filterCriterionWithExpression = new FilterCriterion<>(filterCriterion);
    filterCriterionWithExpression.setExpression(expression);
    add(filterCriterionWithExpression);
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
    return Objects.equals(filterCriteriaList, filtering.filterCriteriaList);
  }

  /**
   * @return returns all filter criterias
   */
  public List<FilterCriteria> getFilterCriteriaList() {
    return filterCriteriaList;
  }

  /**
   * Returns the filter criteria registered for the given property.
   *
   * @param property given property
   * @return the filter criteria registered for the given property
   */
  public FilterCriteria getFilterCriteriaListFor(String property) {
    return filterCriteriaList.stream()
        .filter(f -> f.hasFilterCriterionFor(property))
        .findFirst()
        .orElse(null);
  }

  /** Find the first {@link FilterCriterion} for the given property. */
  public FilterCriterion<?> getFilterCriterionFor(String property) {
    return filterCriteriaList.stream()
        .flatMap(
            fcriteria ->
                fcriteria.hasFilterCriterionFor(property)
                    ? Stream.of(fcriteria.getFilterCriterionFor(property))
                    : null)
        .findFirst()
        .orElse(null);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filterCriteriaList) + Objects.hash("Filtering");
  }

  protected void init() {
    if (filterCriteriaList == null) this.filterCriteriaList = new ArrayList<>(0);
  }

  public Iterator<FilterCriteria> iterator() {
    return filterCriteriaList.iterator();
  }

  /**
   * @param filterCriteria set list of filter criteria
   */
  public void setFilterCriteriaList(List<FilterCriteria> filterCriteria) {
    this.filterCriteriaList = filterCriteria;
  }

  @Override
  public String toString() {
    return "Filtering{" + "filterCriteria=" + filterCriteriaList + '}';
  }

  public abstract static class FilteringBuilder<
      C extends Filtering, B extends FilteringBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }

    /**
     * Adds the {@code filterCriterions} to the first found {@link FilterCriteria} list with the
     * specified {@code criteriaLink} or adds a new one.
     *
     * @param criteriaLink the logical link of the {@link FilterCriteria} that should be extended or
     *     newly created
     * @param criterion {@link FilterCriterion} to add
     */
    public B filterCriterion(FilterLogicalOperator criteriaLink, FilterCriterion<?> criterion) {
      if (filterCriteriaList == null) filterCriteriaList = new ArrayList<>(1);
      filterCriteriaList.stream()
          .filter(fc -> fc.getCriterionLink() == criteriaLink)
          .findFirst()
          .ifPresentOrElse(
              fc -> fc.add(criterion),
              () -> filterCriteriaList.add(new FilterCriteria(criteriaLink, criterion)));
      return self();
    }

    /**
     * Adds the {@code filterCriterion} to the first found AND-linked {@link FilterCriteria} list or
     * adds a new one.
     *
     * @param filterCriterion {@link FilterCriterion} to add
     */
    public B add(FilterCriterion<?> filterCriterion) {
      return filterCriterion(FilterLogicalOperator.AND, filterCriterion);
    }
  }

  //  /**
  //   * Filtering filtering = Filtering.defaultBuilder()
  // .filter("publicationStart").lessOrEqual(now)
  //   * .filter("publicationEnd").greaterOrEqual(now) .build();
  //   */
  //  public static class Builder {
  //
  //    private final List<FilterCriterion> filterCriterias = new ArrayList<>(0);
  //
  //    /**
  //     * Method needed for mapping URL filter param to a filter criterion. only param value
  // available
  //     * during controller, so param name (= expression) only can be set after mapping.
  //     *
  //     * <p>adds a filter criterion to list of filter criterias. if given filterCriterion is null,
  // no
  //     * filter criterion is added (null-safe)
  //     *
  //     * @param expression name of expression (if expression name could not be set during
  //     *     instantiation of FieldCriterion, e.g. during spring mvc type conversion)
  //     * @param filterCriterion filter criterion to add
  //     * @return builder instance for fluent usage
  //     */
  //    public Builder add(String expression, FilterCriterion filterCriterion) {
  //      if (filterCriterion != null) {
  //        filterCriterion.setExpression(expression);
  //      }
  //      return add(filterCriterion);
  //    }
  //
  //    /**
  //     * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no
  //     * filter criteria is added (null-safe)
  //     *
  //     * @param filterCriterion filter criteria to add
  //     * @return builder instance for fluent usage
  //     */
  //    public Builder add(FilterCriterion filterCriterion) {
  //      if (filterCriterion != null) {
  //        if (filterCriterion.getExpression() == null) {
  //          throw new IllegalArgumentException("expression of a filter criterion must not be
  // null!");
  //        }
  //        filterCriterias.add(filterCriterion);
  //      }
  //      return this;
  //    }
  //
  //    public Filtering build() {
  //      return new Filtering(filterCriterias);
  //    }
  //  }
}
