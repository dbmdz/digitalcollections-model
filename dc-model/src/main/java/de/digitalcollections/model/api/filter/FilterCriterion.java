package de.digitalcollections.model.api.filter;

import de.digitalcollections.model.api.filter.enums.FilterOperation;
import java.util.Collection;

/**
 * Filter Criterion Container.A filter criterion is a composition of
 *
 * <ul>
 *   <li>a field name being target of filter operation
 *   <li>a filter operation (operator)
 *   <li>one ore more filter values to be used for filtering operation (operand(s))
 * </ul>
 *
 * References:
 *
 * @param <T> target type for deserializing operand value
 * @see <a href="https://github.com/vijjayy81/spring-boot-jpa-rest-demo-filter-paging-sorting">An
 *     example application using Spring boot MVC, Spring Data JPA with the ability to do filter,
 *     pagination and sorting.</a>
 */
public class FilterCriterion<T extends Object> {

  private FilterOperation operation;

  private String fieldName;

  private Object value;

  private Comparable<?> minValue;

  private Comparable<?> maxValue;

  private Collection<?> values;

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
  @SuppressWarnings("unchecked")
  public FilterCriterion(
      String fieldName,
      FilterOperation operation,
      Object value,
      Comparable<?> minValue,
      Comparable<?> maxValue,
      Collection<?> values) {
    this.operation = operation;
    this.fieldName = fieldName;
    this.value = value;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.values = values;
    validate();

    // ensure min and max value are set correctly:
    if (minValue != null && maxValue != null && ((Comparable) minValue).compareTo(maxValue) > 0) {
      this.minValue = maxValue;
      this.maxValue = minValue;
    }
  }

  /**
   * Constructor for single value Filter Criteria.
   *
   * @param fieldName target field the criteria should be used for
   * @param operation operation of criteria
   * @param value operand of criteria
   */
  public FilterCriterion(String fieldName, FilterOperation operation, Object value) {
    this(fieldName, operation, value, null, null, null);
    if (operation == FilterOperation.BETWEEN
        || operation == FilterOperation.IN
        || operation == FilterOperation.NOT_IN) {
      throw new IllegalArgumentException("this constructor only supports single value operations");
    }
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
    validate();
  }

  /** @return value of a single value operation */
  public Object getValue() {
    return value;
  }

  /** @return minimum value - applicable only for {@link FilterOperation#BETWEEN} */
  public Comparable<?> getMinValue() {
    return minValue;
  }

  /** @return maximum value - applicable only for {@link FilterOperation#BETWEEN} */
  public Comparable<?> getMaxValue() {
    return maxValue;
  }

  /** @return the filter operation. available operations see {@link FilterOperation} */
  public FilterOperation getOperation() {
    return operation;
  }

  /** @return field name being target of filter operation */
  public String getFieldName() {
    return fieldName;
  }

  /** @return values of a multi value operation of field type T */
  public Collection<?> getValues() {
    return values;
  }

  private void validate() {
    if (operation == null) {
      throw new IllegalArgumentException("a filter criterion needs an operation");
    }
    final FilterOperation.OperandCount operandCount = operation.getOperandCount();
    switch (operandCount) {
      case NO_VALUE:
        if (value != null
            || minValue != null
            || maxValue != null
            || (values != null && !values.isEmpty())) {
          throw new IllegalArgumentException("operation does not support operand values!");
        }
        break;
      case SINGLEVALUE:
        if (value == null
            || minValue != null
            || maxValue != null
            || (values != null && !values.isEmpty())) {
          throw new IllegalArgumentException("operation requires exactly one operand value!");
        }
        break;
      case MIN_MAX_VALUES:
        if (value != null
            || minValue == null
            || maxValue == null
            || (values != null && !values.isEmpty())) {
          throw new IllegalArgumentException(
              "operation requires exactly one min and one max value!");
        }
        break;
      case MULTIVALUE:
        if (value != null
            || minValue != null
            || maxValue != null
            || (values == null || values.isEmpty())) {
          throw new IllegalArgumentException("operation requires a list of values!");
        }
        break;
    }
  }
}
