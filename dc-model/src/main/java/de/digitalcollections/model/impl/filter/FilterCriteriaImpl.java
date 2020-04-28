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
    if (fieldName == null) {
      throw new IllegalArgumentException("a fieldName is required");
    }
    this.operation = operation;
    this.fieldName = fieldName;
    this.value = value;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.values = values;
  }

  /**
   * Constructor for single value Filter Criteria.
   *
   * @param fieldName target field the criteria should be used for
   * @param operation operation of criteria
   * @param value operand of criteria
   */
  public FilterCriteriaImpl(String fieldName, FilterOperation operation, T value) {
    this(fieldName, operation, value, null, null, null);
    if (operation == FilterOperation.BETWEEN
        || operation == FilterOperation.IN
        || operation == FilterOperation.NOT_IN) {
      throw new IllegalArgumentException("this constructor only supports single value operations");
    }
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public T getMinValue() {
    if (minValue != null && maxValue != null && minValue.compareTo(maxValue) > 0) {
      return maxValue;
    }
    return minValue;
  }

  @Override
  public T getMaxValue() {
    if (minValue != null && maxValue != null && minValue.compareTo(maxValue) > 0) {
      return minValue;
    }
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
