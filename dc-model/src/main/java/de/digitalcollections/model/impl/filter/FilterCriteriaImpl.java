package de.digitalcollections.model.impl.filter;

import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import java.util.Collection;

/** @param <T> field-type of field to be filtered (operand), e.g. Date, LocalDate, Long, etc. */
public class FilterCriteriaImpl<T extends Comparable> implements FilterCriteria<T> {

  private FilterOperation operation;

  private String fieldName;

  private T value;

  private T minValue;

  private T maxValue;

  private Collection<T> values;

  //  public FilterCriteriaImpl() {}

  /**
   * Constructor for Filter Criteria.
   *
   * @param fieldName target field the criteria should be used for
   * @param operation operation of criteria
   * @param value operand of criteria
   * @param minValue minimum value of between operation
   * @param maxValue maximum value of between operation
   * @param values operand(s) of criteria
   */
  public FilterCriteriaImpl(
      String fieldName,
      FilterOperation operation,
      T value,
      T minValue,
      T maxValue,
      Collection<T> values) {
    this.operation = operation;
    this.fieldName = fieldName;
    this.value = value;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.values = values;
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public T getMinValue() {
    return minValue;
  }

  @Override
  public T getMaxValue() {
    return maxValue;
  }

  @Override
  public FilterOperation getOperation() {
    return operation;
  }

  @Override
  public String getFieldName() {
    return fieldName;
  }

  @Override
  public Collection<T> getValues() {
    return values;
  }

  @Override
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public void setMinValue(T minValue) {
    this.minValue = minValue;
  }

  public void setMaxValue(T maxValue) {
    this.maxValue = maxValue;
  }

  public void setOperation(FilterOperation operation) {
    this.operation = operation;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void setValues(Collection<T> values) {
    this.values = values;
  }
}
