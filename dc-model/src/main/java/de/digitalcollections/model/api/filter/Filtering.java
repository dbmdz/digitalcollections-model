package de.digitalcollections.model.api.filter;

import de.digitalcollections.model.api.filter.enums.FilterOperation;
import de.digitalcollections.model.impl.filter.FilterCriteriaImpl;
import de.digitalcollections.model.impl.filter.FilteringImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Filtering<T extends Comparable> extends Iterable<FilterCriteria<T>>, Serializable {

  /**
   * Returns the filter criteria registered for the given property.
   *
   * @param property given property
   * @return the filter criteria registered for the given property
   */
  FilterCriteria<T> getFilterCriteriaFor(String property);

  /** @return returns all filter criterias */
  List<FilterCriteria<T>> getFilterCriterias();

  static FilteringBuilder defaultBuilder() {
    return new FilteringBuilder();
  }

  /**
   * Filtering filtering = Filtering.defaultBuilder() .filter("publicationStart").lessOrEqual(now)
   * .filter("publicationEnd").greaterOrEqual(now) .build();
   */
  class FilteringBuilder<T extends Comparable> {

    private final List<FilterCriteria<T>> filterCriterias = new ArrayList<>();

    /**
     * Initializes construction of a filter criterion for a field
     *
     * @param fieldName name of field
     * @return builder instance for fluent usage
     */
    @SuppressWarnings("unchecked")
    public FilterCriteriaBuilder<T> filter(String fieldName) {
      return new FilterCriteriaBuilder(fieldName, this);
    }

    /**
     * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no
     * filter criteria is added (null-safe)
     *
     * @param fieldName name of field (if field name could not be set during instantiation of
     *     FieldCriteria, e.g. during spring mvxc type conversion)
     * @param filterCriteria filter criteria to add
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> add(String fieldName, FilterCriteria<T> filterCriteria) {
      if (filterCriteria != null) {
        filterCriteria.setFieldName(fieldName);
      }
      return add(filterCriteria);
    }

    /**
     * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no
     * filter criteria is added (null-safe)
     *
     * @param filterCriteria filter criteria to add
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> add(FilterCriteria<T> filterCriteria) {
      if (filterCriteria != null) {
        if (filterCriteria.getFieldName() == null) {
          throw new IllegalArgumentException("field name of a filter criteria must not be null!");
        }
        filterCriterias.add(filterCriteria);
      }
      return this;
    }

    @SuppressWarnings("unchecked")
    public Filtering<T> build() {
      return new FilteringImpl(filterCriterias);
    }
  }

  class FilterCriteriaBuilder<T extends Comparable> {

    private final FilteringBuilder<T> filteringBuilder;
    private final FilterCriteria<T> filterCriteria;

    private FilterCriteriaBuilder(String fieldName, FilteringBuilder<T> filteringBuilder) {
      this.filteringBuilder = filteringBuilder;
      this.filterCriteria = new FilterCriteriaImpl<>(fieldName, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#BETWEEN}
     *
     * @param minValue lower bound of between (included)
     * @param maxValue upper bound of between (included)
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> between(T minValue, T maxValue) {
      return enrichAndAddFilterCriteriaInBuild(
          FilterOperation.BETWEEN, null, minValue, maxValue, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#CONTAINS}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> contains(T value) {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.BETWEEN, value, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#EQUALS}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> equals(T value) {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.EQUALS, value, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> greater(T value) {
      return enrichAndAddFilterCriteriaInBuild(
          FilterOperation.GREATER_THAN, value, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN_OR_EQUAL_TO}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> greaterOrEqual(T value) {
      return enrichAndAddFilterCriteriaInBuild(
          FilterOperation.GREATER_THAN_OR_EQUAL_TO, value, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#IN}
     *
     * @param values list of values field value should be in
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> in(Collection<T> values) {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.IN, null, null, null, values);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> less(T value) {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.LESS_THAN, value, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESSTHAN_OR_EQUAL_TO}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> lessOrEqual(T value) {
      return enrichAndAddFilterCriteriaInBuild(
          FilterOperation.LESSTHAN_OR_EQUAL_TO, value, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#NOT_EQUALS}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> notEquals(T value) {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.NOT_EQUALS, value, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#IN}
     *
     * @param values list of values field value should not be in
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> notIn(Collection<T> values) {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.NOT_IN, null, null, null, values);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#NOT_SET}
     *
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> notSet() {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.NOT_SET, null, null, null, null);
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#SET}
     *
     * @return builder instance for fluent usage
     */
    public FilteringBuilder<T> set() {
      return enrichAndAddFilterCriteriaInBuild(FilterOperation.SET, null, null, null, null);
    }

    private FilteringBuilder<T> enrichAndAddFilterCriteriaInBuild(
        FilterOperation operation, T value, T minValue, T maxValue, Collection<T> values)
        throws IllegalStateException {
      filterCriteria.setOperation(operation);
      filterCriteria.setValue(value);
      filterCriteria.setMinValue(minValue);
      filterCriteria.setMaxValue(maxValue);
      filterCriteria.setValues(values);
      filteringBuilder.add(filterCriteria);
      return filteringBuilder;
    }
  }
}
