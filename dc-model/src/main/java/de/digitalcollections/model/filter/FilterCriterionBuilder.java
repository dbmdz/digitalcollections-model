package de.digitalcollections.model.filter;

import java.util.Collection;

public class FilterCriterionBuilder {

  private final String fieldName;
  private final FilteringBuilder filteringBuilder;

  FilterCriterionBuilder(String fieldName, FilteringBuilder filteringBuilder) {
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
        new FilterCriterion(fieldName, FilterOperation.GREATER_THAN_OR_EQUAL_TO_OR_NOT_SET, value);
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
   * FilterOperation#EQUALS}
   *
   * <p>Note: had to rename it to "isEquals" because of name clash with Object.equals
   *
   * @param value operand
   * @return builder instance for fluent usage
   */
  public FilteringBuilder isEquals(Object value) {
    FilterCriterion filterCriterion = new FilterCriterion(fieldName, FilterOperation.EQUALS, value);
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
   * FilterOperation#LESS_THAN_AND_SET}
   *
   * @param value operand
   * @return builder instance for fluent usage
   */
  public FilteringBuilder lessAndSet(Object value) {
    FilterCriterion filterCriterion =
        new FilterCriterion(fieldName, FilterOperation.LESS_THAN_AND_SET, value);
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
   * FilterOperation#LESS_THAN_OR_EQUAL_TO_AND_SET}
   *
   * @param value operand
   * @return builder instance for fluent usage
   */
  public FilteringBuilder lessOrEqualAndSet(Object value) {
    FilterCriterion filterCriterion =
        new FilterCriterion(fieldName, FilterOperation.LESS_THAN_OR_EQUAL_TO_AND_SET, value);
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
    FilterCriterion filterCriterion = new FilterCriterion(fieldName, FilterOperation.NOT_SET, null);
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

  /**
   * Completes construction of a filter criterion for a field with operation {@link
   * FilterOperation#STARTS_WITH}
   *
   * @param value operand
   * @return builder instance for fluent usage
   */
  public FilteringBuilder startsWith(Object value) {
    FilterCriterion filterCriterion =
        new FilterCriterion(fieldName, FilterOperation.STARTS_WITH, value);
    filteringBuilder.add(filterCriterion);
    return filteringBuilder;
  }
}
