package de.digitalcollections.model.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Filtering filtering = Filtering.defaultBuilder() .filter("publicationStart").lessOrEqual(now)
 * .filter("publicationEnd").greaterOrEqual(now) .build();
 */
public class FilteringBuilder {

  private final List<FilterCriterion> filterCriterias = new ArrayList<>();

  /**
   * Initializes construction of a filter criterion for a field
   *
   * @param fieldName name of field
   * @return builder instance for fluent usage
   */
  @SuppressWarnings(value = "unchecked")
  public FilterCriterionBuilder filter(String fieldName) {
    return new FilterCriterionBuilder(fieldName, this);
  }

  /**
   * Method needed for mapping URL filter param to a filter criterion. only param value available
   * during controller, so param name (= fieldname) only can be set after mapping.
   *
   * <p>adds a filter criterion to list of filter criterias. if given filterCriterion is null, no
   * filter criterion is added (null-safe)
   *
   * @param fieldName name of field (if field name could not be set during instantiation of
   *     FieldCriterion, e.g. during spring mvc type conversion)
   * @param filterCriterion filter criterion to add
   * @return builder instance for fluent usage
   */
  public FilteringBuilder add(String fieldName, FilterCriterion filterCriterion) {
    if (filterCriterion != null) {
      filterCriterion.setFieldName(fieldName);
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
      if (filterCriterion.getFieldName() == null) {
        throw new IllegalArgumentException("field name of a filter criterion must not be null!");
      }
      filterCriterias.add(filterCriterion);
    }
    return this;
  }

  @SuppressWarnings(value = "unchecked")
  public Filtering build() {
    return (Filtering) new Filtering(filterCriterias);
  }
}
