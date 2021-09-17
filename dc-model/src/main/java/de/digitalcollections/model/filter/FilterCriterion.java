package de.digitalcollections.model.filter;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Filter Criterion Container.A filter criterion is a composition of
 *
 * <ul>
 *   <li>an expression (e.g. field name) being target of filter operation
 *   <li>a filter operation (operator)
 *   <li>one ore more filter values to be used for filtering operation (operand(s))
 *   <li>a flag to indicate if expression has to be mapped or be used unchanged in
 *       underlying backend system (e.g. mapping Java member names to database column names vs. no
 *       mapping needed because expression is already backend/database specific)
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

  private String expression;
  private Comparable<?> maxValue;
  private Comparable<?> minValue;
  private boolean nativeExpression;
  private FilterOperation operation;
  private Object value;
  private Collection<?> values;

  /**
   * Constructor for a filter criterion.
   *
   * @param expression expression the criterion should be used for
   * @param nativeExpression a flag to indicate if expression has to be mapped or should
   *     be used unchanged/as is in underlying backend system (e.g. mapping Java member names to
   *     database column names; if "true" no mapping needed (should not be exposed to public
   *     modifications, just use internally for security reasons) because expression is already e.g.
   *     backend/database specific)
   * @param operation operation of criterion
   * @param value operand of criterion
   * @param minValue minimum value of between operation
   * @param maxValue maximum value of between operation
   * @param values operand(s) of criterion
   */
  @SuppressWarnings("unchecked")
  public FilterCriterion(
      String expression,
      boolean nativeExpression,
      FilterOperation operation,
      Object value,
      Comparable<?> minValue,
      Comparable<?> maxValue,
      Collection<?> values) {
    this.expression = expression;
    this.nativeExpression = nativeExpression;
    this.operation = operation;
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
   * Constructor for a non-native expression filter criterion.
   *
   * @param expression expression the criterion should be used for
   * @param operation operation of criterion
   * @param value operand of criterion
   * @param minValue minimum value of between operation
   * @param maxValue maximum value of between operation
   * @param values operand(s) of criterion
   */
  @SuppressWarnings("unchecked")
  public FilterCriterion(
      String expression,
      FilterOperation operation,
      Object value,
      Comparable<?> minValue,
      Comparable<?> maxValue,
      Collection<?> values) {
    this(expression, false, operation, value, minValue, maxValue, values);
  }

  /**
   * Constructor for single value Filter Criterion.
   *
   * @param expression expression the criterion should be used for
   * @param operation operation of criterion
   * @param value operand of criterion
   */
  public FilterCriterion(String expression, FilterOperation operation, Object value) {
    this(expression, false, operation, value);
  }

  /**
   * Constructor for single value Filter Criterion.
   *
   * @param expression expression the criterion should be used for
   * @param nativeExpression true if expression is native (to be handled "as is")
   * @param operation operation of criterion
   * @param value operand of criterion
   */
  public FilterCriterion(
      String expression, boolean nativeExpression, FilterOperation operation, Object value) {
    this(expression, nativeExpression, operation, value, null, null, null);
    if (operation == FilterOperation.BETWEEN
        || operation == FilterOperation.IN
        || operation == FilterOperation.NOT_IN) {
      throw new IllegalArgumentException("this constructor only supports single value operations");
    }
  }

  /**
   * Constructor for no value Filter Criterion.
   *
   * @param expression expression the criterion should be used for
   * @param operation operation of criterion
   */
  public FilterCriterion(String expression, FilterOperation operation) {
    this(expression, false, operation);
  }

  /**
   * Constructor for no value Filter Criterion.
   *
   * @param expression expression the criterion should be used for
   * @param nativeExpression true if expression is native (to be handled "as is")
   * @param operation operation of criterion
   */
  public FilterCriterion(String expression, boolean nativeExpression, FilterOperation operation) {
    this(expression, nativeExpression, operation, null, null, null, null);
  }

  /** @return expression being target of filter operation */
  public String getExpression() {
    return expression;
  }

  /**
   * @return field name being target of filter operation
   * @deprecated use getExpression() instead
   */
  @Deprecated
  public String getFieldName() {
    return expression;
  }

  /** @return maximum value - applicable only for {@link FilterOperation#BETWEEN} */
  public Comparable<?> getMaxValue() {
    return maxValue;
  }

  /** @return minimum value - applicable only for {@link FilterOperation#BETWEEN} */
  public Comparable<?> getMinValue() {
    return minValue;
  }

  /** @return the filter operation. available operations see {@link FilterOperation} */
  public FilterOperation getOperation() {
    return operation;
  }

  /** @return value of a single value operation */
  public Object getValue() {
    return value;
  }

  /** @return values of a multi value operation of field type T */
  public Collection<?> getValues() {
    return values;
  }

  public boolean isNativeExpression() {
    return nativeExpression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
    validate();
  }

  /**
   * @param expression criterion expression
   * @deprecated use setExpression(String expression) instead
   */
  public void setFieldName(String expression) {
    setExpression(expression);
  }

  public void setNativeExpression(boolean nativeExpression) {
    this.nativeExpression = nativeExpression;
  }

  @Override
  public String toString() {
    if (operation == null) {
      return "";
    }
    String criterion = expression + "=" + operation + ":";
    switch (operation.getOperandCount()) {
      case SINGLEVALUE:
        criterion += value;
        break;
      case MIN_MAX_VALUES:
        criterion += minValue + "," + maxValue;
        break;
      case MULTIVALUE:
        criterion += values.stream().map(Object::toString).collect(Collectors.joining(","));
        break;
    }
    if (nativeExpression) {
      return "native expression / " + criterion;
    } else {
      return criterion;
    }
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
