package de.digitalcollections.model.list.filtering;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Filter Criterion Container.A filter criterion is a composition of
 *
 * <ul>
 *   <li>an expression (e.g. field name) being target of filter operation
 *   <li>a filter operation (operator)
 *   <li>one ore more filter values to be used for filtering operation (operand(s))
 *   <li>a flag to indicate if the expression is native and has to be used unchanged in the
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

  public static Builder builder() {
    return new Builder();
  }

  public static Builder nativeBuilder() {
    return new Builder().withNativeExpression(true);
  }

  private String expression;
  private Comparable<?> maxValue;
  private Comparable<?> minValue;
  private boolean nativeExpression;
  private FilterOperation operation;
  private Object value;
  private Collection<?> values;

  public FilterCriterion() {
    init();
  }

  /**
   * Constructor for a filter criterion.
   *
   * @param expression expression the criterion should be used for
   * @param nativeExpression a flag to indicate if the expression is native and has to be used
   *     unchanged/as is in underlying backend system (e.g. mapping Java member names to database
   *     column names; if "true" no mapping needed (should not be exposed to public modifications,
   *     just use internally for security reasons) because expression is already e.g.
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

  /**
   * Copy constructor
   *
   * @param other
   */
  public FilterCriterion(FilterCriterion other) {
    this.expression = other.expression;
    this.maxValue = other.maxValue;
    this.minValue = other.minValue;
    this.nativeExpression = other.nativeExpression;
    this.operation = other.operation;
    this.value = other.value;
    this.values = other.values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FilterCriterion)) {
      return false;
    }
    FilterCriterion<?> that = (FilterCriterion<?>) o;
    return nativeExpression == that.nativeExpression
        && Objects.equals(expression, that.expression)
        && Objects.equals(maxValue, that.maxValue)
        && Objects.equals(minValue, that.minValue)
        && operation == that.operation
        && Objects.equals(value, that.value)
        && Objects.equals(values, that.values);
  }

  /**
   * @return expression being target of filter operation
   */
  public String getExpression() {
    return expression;
  }

  /**
   * @return maximum value - applicable only for {@link FilterOperation#BETWEEN}
   */
  public Comparable<?> getMaxValue() {
    return maxValue;
  }

  /**
   * @return minimum value - applicable only for {@link FilterOperation#BETWEEN}
   */
  public Comparable<?> getMinValue() {
    return minValue;
  }

  /**
   * @return the filter operation. available operations see {@link FilterOperation}
   */
  public FilterOperation getOperation() {
    return operation;
  }

  /**
   * @return value of a single value operation
   */
  public Object getValue() {
    return value;
  }

  /**
   * @return values of a multi value operation of field type T
   */
  public Collection<?> getValues() {
    return values;
  }

  @Override
  public int hashCode() {
    return Objects.hash(expression, maxValue, minValue, nativeExpression, operation, value, values);
  }

  protected void init() {}

  public boolean isNativeExpression() {
    return nativeExpression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  /**
   * @param expression criterion expression
   * @deprecated use setExpression(String expression) instead
   */
  @Deprecated
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

  public static class Builder {

    private String expression;
    private FilterCriterion filterCriterion;
    private boolean nativeExpression;

    Builder() {}

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#BETWEEN}
     *
     * @param minValue lower bound of between (included)
     * @param maxValue upper bound of between (included)
     * @return builder instance for fluent usage
     */
    public Builder between(Comparable<?> minValue, Comparable<?> maxValue) {
      filterCriterion =
          new FilterCriterion(
              expression, false, FilterOperation.BETWEEN, null, minValue, maxValue, null);
      return this;
    }

    public FilterCriterion build() {
      return filterCriterion;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#CONTAINS}
     *
     * @param expression expression (not a native expression)
     * @param value operand
     * @return builder instance for fluent usage
     */
    @Deprecated
    public Builder contains(String expression, Object value) {
      filterCriterion = new FilterCriterion(expression, false, FilterOperation.CONTAINS, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#CONTAINS}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder contains(Object value) {
      filterCriterion = new FilterCriterion(expression, false, FilterOperation.CONTAINS, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder greater(Object value) {
      filterCriterion =
          new FilterCriterion(expression, nativeExpression, FilterOperation.GREATER_THAN, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN_OR_EQUAL_TO}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder greaterOrEqual(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.GREATER_THAN_OR_EQUAL_TO, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN_OR_EQUAL_TO_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder greaterOrEqualOrNotSet(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression,
              nativeExpression,
              FilterOperation.GREATER_THAN_OR_EQUAL_TO_OR_NOT_SET,
              value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#GREATER_THAN_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder greaterOrNotSet(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.GREATER_THAN_OR_NOT_SET, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#IN}
     *
     * @param values list of values field value should be in
     * @return builder instance for fluent usage
     */
    public Builder in(Collection<?> values) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.IN, null, null, null, values);
      return this;
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
    public Builder isEquals(Object value) {
      if (value != null) {
        filterCriterion =
            new FilterCriterion(expression, nativeExpression, FilterOperation.EQUALS, value);
      } else {
        filterCriterion =
            new FilterCriterion(expression, nativeExpression, FilterOperation.NOT_SET);
      }
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#EQUALS_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder isEqualsOrNotSet(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.EQUALS_OR_NOT_SET, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder less(Object value) {
      filterCriterion =
          new FilterCriterion(expression, nativeExpression, FilterOperation.LESS_THAN, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_AND_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder lessAndSet(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.LESS_THAN_AND_SET, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_OR_EQUAL_TO}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder lessOrEqual(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.LESS_THAN_OR_EQUAL_TO, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_OR_EQUAL_TO_AND_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder lessOrEqualAndSet(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.LESS_THAN_OR_EQUAL_TO_AND_SET, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_OR_EQUAL_TO_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder lessOrEqualOrNotSet(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression,
              nativeExpression,
              FilterOperation.LESS_THAN_OR_EQUAL_TO_OR_NOT_SET,
              value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#LESS_THAN_OR_NOT_SET}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder lessOrNotSet(Object value) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.LESS_THAN_OR_NOT_SET, value);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#NOT_EQUALS}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder notEquals(Object value) {
      if (value != null) {
        filterCriterion =
            new FilterCriterion(expression, nativeExpression, FilterOperation.NOT_EQUALS, value);
      } else {
        filterCriterion = new FilterCriterion(expression, nativeExpression, FilterOperation.SET);
      }
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#IN}
     *
     * @param values list of values field value should not be in
     * @return builder instance for fluent usage
     */
    public Builder notIn(Collection<?> values) {
      filterCriterion =
          new FilterCriterion(
              expression, nativeExpression, FilterOperation.NOT_IN, null, null, null, values);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#NOT_SET}
     *
     * @return builder instance for fluent usage
     */
    public Builder notSet() {
      filterCriterion =
          new FilterCriterion(expression, nativeExpression, FilterOperation.NOT_SET, null);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#SET}
     *
     * @return builder instance for fluent usage
     */
    public Builder set() {
      filterCriterion =
          new FilterCriterion(expression, nativeExpression, FilterOperation.SET, null);
      return this;
    }

    /**
     * Completes construction of a filter criterion for a field with operation {@link
     * FilterOperation#STARTS_WITH}
     *
     * @param value operand
     * @return builder instance for fluent usage
     */
    public Builder startsWith(Object value) {
      filterCriterion =
          new FilterCriterion(expression, nativeExpression, FilterOperation.STARTS_WITH, value);
      return this;
    }

    public Builder withExpression(String expression) {
      this.expression = expression;
      return this;
    }

    public Builder withNativeExpression(boolean nativeExpression) {
      this.nativeExpression = nativeExpression;
      return this;
    }
  }
}
