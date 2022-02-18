package de.digitalcollections.model.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Filtering filtering = Filtering.defaultBuilder() .filter("publicationStart").lessOrEqual(now)
 * .filter("publicationEnd").greaterOrEqual(now) .build();
 */
public class FilteringBuilder {

  private final List<FilterCriterion> filterCriterias = new ArrayList<>();

  /**
   * Method needed for mapping URL filter param to a filter criterion. only param value available
   * during controller, so param name (= expression) only can be set after mapping.
   *
   * <p>adds a filter criterion to list of filter criterias. if given filterCriterion is null, no
   * filter criterion is added (null-safe)
   *
   * @param expression name of expression (if expression name could not be set during instantiation
   *     of FieldCriterion, e.g. during spring mvc type conversion)
   * @param filterCriterion filter criterion to add
   * @return builder instance for fluent usage
   */
  public FilteringBuilder add(String expression, FilterCriterion filterCriterion) {
    if (filterCriterion != null) {
      filterCriterion.setExpression(expression);
    }
    return add(filterCriterion);
  }

  /**
   * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no filter
   * criteria is added (null-safe)
   *
   * @param filterCriterion filter criteria to add
   * @return builder instance for fluent usage
   */
  public FilteringBuilder add(FilterCriterion filterCriterion) {
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

  /**
   * Initializes construction of a filter criterion for a non-native expression
   *
   * @param expression expression filtering is executed on
   * @return builder instance for fluent usage
   */
  public FilterCriterionBuilder filter(String expression) {
    return new FilterCriterionBuilder(expression, false, this);
  }

  /**
   * Initializes construction of a filter criterion for a native expression
   *
   * @param expression native expression filtering is executed on
   * @return builder instance for fluent usage
   */
  public FilterCriterionBuilder filterNative(String expression) {
    return new FilterCriterionBuilder(expression, true, this);
  }
}
