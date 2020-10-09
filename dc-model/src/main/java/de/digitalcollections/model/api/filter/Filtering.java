package de.digitalcollections.model.api.filter;

import de.digitalcollections.model.api.filter.enums.FilterOperation;
import de.digitalcollections.model.impl.filter.FilteringImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Container for a list of {@link FilterCriterion}s */
public interface Filtering extends Iterable<FilterCriterion>, Serializable {

  /**
   * Add all filter criteria of given filtering to existing filtering. Initialise if no existing
   * filtering.
   *
   * @param filtering new filtering to add
   * @return complete filtering
   */
  default List<FilterCriterion> add(Filtering filtering) {
    if (filtering == null || filtering.getFilterCriteria() == null) {
      return getFilterCriteria();
    }
    if (getFilterCriteria() == null) {
      setFilterCriteria(filtering.getFilterCriteria());
      return getFilterCriteria();
    }
    addFilterCriteria(filtering.getFilterCriteria());
    return getFilterCriteria();
  }

  default void addFilterCriteria(List<FilterCriterion> filterCriteria) {
    getFilterCriteria().addAll(filterCriteria);
  }

  /**
   * Returns the filter criteria registered for the given property.
   *
   * @param property given property
   * @return the filter criteria registered for the given property
   */
  FilterCriterion getFilterCriterionFor(String property);

  /** @return returns all filter criterias */
  List<FilterCriterion> getFilterCriteria();

  /** @param filterCriteria set list of filter criteria */
  void setFilterCriteria(List<FilterCriterion> filterCriteria);

  static FilteringBuilder defaultBuilder() {
    return new FilteringBuilder();
  }

  /**
   * Filtering filtering = Filtering.defaultBuilder() .filter("publicationStart").lessOrEqual(now)
   * .filter("publicationEnd").greaterOrEqual(now) .build();
   */
  class FilteringBuilder {

    private final List<FilterCriterion> filterCriterias = new ArrayList<>();

    /**
     * Initializes construction of a filter criterion for a field
     *
     * @param fieldName name of field
     * @return builder instance for fluent usage
     */
    @SuppressWarnings("unchecked")
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
     * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no
     * filter criteria is added (null-safe)
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

    @SuppressWarnings("unchecked")
    public Filtering build() {
      return (Filtering) new FilteringImpl(filterCriterias);
    }
  }

  class FilterCriterionBuilder {

    private final FilteringBuilder filteringBuilder;
    private final String fieldName;

    private FilterCriterionBuilder(String fieldName, FilteringBuilder filteringBuilder) {
      this.filteringBuilder = filteringBuilder;
      this.fieldName = fieldName;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#BETWEEN}
     *
     * @param minValue lower bound of between (included)
     * @param maxValue upper bound of between (included)
     * @return builder instance for fluent usage
     */
    public FilteringBuilder between(Comparable<?> minValue, Comparable<?> maxValue) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.BETWEEN, null, minValue, maxValue, null);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#CONTAINS}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder contains(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.CONTAINS, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#EQUALS}
     *
     * <p>Note: had to rename it to "isEquals" because of name clash with Object.equals
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder isEquals(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.EQUALS, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }
    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#EQUALS_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder isEqualsOrNotSet(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.EQUALS_OR_NOT_SET, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder greater(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.GREATER_THAN, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder greaterOrNotSet(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.GREATER_THAN_OR_NOT_SET, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN_OR_EQUAL_TO}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder greaterOrEqual(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.GREATER_THAN_OR_EQUAL_TO, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN_OR_EQUAL_TO_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder greaterOrEqualOrNotSet(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(
              fieldName, FilterOperation.GREATER_THAN_OR_EQUAL_TO_OR_NOT_SET, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#IN}
     *
     * @param values list of values field value should be in
     * @return builder instance for fluent usage
     */
    public FilteringBuilder in(Collection<?> values) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.IN, null, null, null, values);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder less(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.LESS_THAN, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder lessOrNotSet(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.LESS_THAN_OR_NOT_SET, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_OR_EQUAL_TO}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder lessOrEqual(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.LESS_THAN_OR_EQUAL_TO, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_OR_EQUAL_TO_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder lessOrEqualOrNotSet(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.LESS_THAN_OR_EQUAL_TO_OR_NOT_SET, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#NOT_EQUALS}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder notEquals(Object value) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.NOT_EQUALS, value);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#IN}
     *
     * @param values list of values field value should not be in
     * @return builder instance for fluent usage
     */
    public FilteringBuilder notIn(Collection<?> values) {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.NOT_IN, null, null, null, values);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#NOT_SET}
     *
     * @return builder instance for fluent usage
     */
    public FilteringBuilder notSet() {
      FilterCriterion filterCriterion =
          new FilterCriterion(fieldName, FilterOperation.NOT_SET, null);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#SET}
     *
     * @return builder instance for fluent usage
     */
    public FilteringBuilder set() {
      FilterCriterion filterCriterion = new FilterCriterion(fieldName, FilterOperation.SET, null);
      filteringBuilder.add(filterCriterion);
      return filteringBuilder;
    }
  }
}
