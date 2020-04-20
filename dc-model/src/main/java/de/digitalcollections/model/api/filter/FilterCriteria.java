package de.digitalcollections.model.api.filter;

import de.digitalcollections.model.api.filter.enums.FilterOperation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * Filter Criteria Holder
 */
public class FilterCriteria<T extends Comparable<T>> {

  private static final Map<Class<?>, Function<String, ? extends Comparable<?>>> fromStringConverters = new HashMap<>();

  static {
    // initialise with "well known" conversion functions from string
    fromStringConverters.put(Integer.class, Integer::valueOf);
    fromStringConverters.put(Long.class, Long::valueOf);
    fromStringConverters.put(LocalDate.class, LocalDate::parse);
    fromStringConverters.put(String.class, s -> s);
  }

  /**
   * Holds the operation {@link FilterOperation}
   */
  private FilterOperation operation;

  /**
   * Table column name
   */
  private String fieldName;

  /**
   * Holds the Function to convertString to <T>
   */
  private Function<String, T> converterFunction;

  /**
   * Converted value
   */
  private T convertedSingleValue;

  /**
   * minimum value - application only for {@link FilterOperation#BETWEEN}
   */
  private T minValue;

  /**
   * maximum value - application only for {@link FilterOperation#BETWEEN}
   */
  private T maxValue;

  /**
   * Holds the filter criteria
   */
  private Collection<String> originalValues;

  /**
   * Holds the filter criteria as type <T>
   */
  private Collection<T> convertedValues;

  public FilterCriteria(String fieldName, String operationAndValue, Class<T> valueType) {
    this(fieldName, operationAndValue, (Function<String, T>) fromStringConverters.get(valueType));
  }

  /**
   * Constructor for Filter Criteria with DB table column name, filter string and converter function
   * <br>
   *
   * <table border="1">
   * <caption>Filter Criteria Structure</caption>
   * <tr>
   * <td>Symbol</td>
   * <td>Operation</td>
   * <td>Example filter query param</td>
   * <tr>
   * <td>eq</td>
   * <td>Equals</td>
   * <td>city=eq:Sydney</td>
   * <tr>
   * <td>neq</td>
   * <td>Not Equals</td>
   * <td>country=neq:uk</td>
   * <tr>
   * <td>gt</td>
   * <td>Greater Than</td>
   * <td>amount=gt:10000</td>
   * <tr>
   * <td>gte</td>
   * <td>Greater Than or equals to</td>
   * <td>amount=gte:10000</td>
   * <tr>
   * <td>lt</td>
   * <td>Less Than</td>
   * <td>amount=lt:10000</td>
   * <tr>
   * <td>lte</td>
   * <td>Less Than or equals to</td>
   * <td>amount=lte:10000</td>
   * <tr>
   * <td>in</td>
   * <td>IN</td>
   * <td>country=in:uk, usa, au</td>
   * <tr>
   * <td>nin</td>
   * <td>Not IN</td>
   * <td>country=nin:fr, de, nz</td>
   * <tr>
   * <td>btn</td>
   * <td>Between</td>
   * <td>joiningDate=btn:2018-01-01, 2016-01-01</td>
   * <tr>
   * <td>like</td>
   * <td>Like</td>
   * <td>firstName=like:John</td>
   * </tr>
   * </table>
   *
   * @param fieldName
   * @param filter
   * @param converterFunction
   */
  public FilterCriteria(String fieldName, String filter, Function<String, T> converterFunction) {
    // Validations
    Assert.isTrue(!StringUtils.isEmpty(fieldName), "Field name can't be empty");
    Assert.isTrue(!StringUtils.isEmpty(filter), "Filter criteria can't be empty");

    this.converterFunction = converterFunction;
    this.fieldName = fieldName;

    String[] filterSplit = StringUtils.split(filter, ":");
    if (filterSplit.length != 2) {
      throw new IllegalArgumentException("More than one or no separator ':' found");
    }

    String operation = filterSplit[0];
    String operationValue = filterSplit[1];

    // Convert the operation name to enum
    this.operation = FilterOperation.fromValue(operation);

    String[] operationValues;
    if (!operationValue.contains(",")) {
      operationValues = new String[]{operationValue};
    } else {
      // Split the filter value as comma separated.
      operationValues = StringUtils.split(operationValue, ",");
    }
    if (operationValues.length < 1) {
      throw new IllegalArgumentException("Operation value can't be empty");
    }

    this.originalValues = Arrays.asList(operationValues);
    this.convertedValues = new ArrayList<>();

    // Validate other conditions
    validateAndAssign(operationValues);
  }

  private void validateAndAssign(String[] operationValues) {

    // For operation 'btn'
    if (FilterOperation.BETWEEN == operation) {
      if (operationValues.length != 2) {
        throw new IllegalArgumentException("For 'btn' operation two values are expected");
      } else {

        // Convert
        T value1 = this.converterFunction.apply(operationValues[0]);
        T value2 = this.converterFunction.apply(operationValues[1]);

        // Set min and max values
        if (value1.compareTo(value2) > 0) {
          this.minValue = value2;
          this.maxValue = value1;
        } else {
          this.minValue = value1;
          this.maxValue = value2;
        }
      }

      // For 'in' or 'nin' operation
    } else if (FilterOperation.IN == operation || FilterOperation.NOT_IN == operation) {
      convertedValues.addAll(
              originalValues.stream().map(converterFunction).collect(Collectors.toList()));
    } else {
      // All other operation
      this.convertedSingleValue = converterFunction.apply(operationValues[0]);
    }
  }

  public T getConvertedSingleValue() {
    return convertedSingleValue;
  }

  public T getMinValue() {
    return minValue;
  }

  public T getMaxValue() {
    return maxValue;
  }

  public FilterOperation getOperation() {
    return operation;
  }

  public String getFieldName() {
    return fieldName;
  }

  public Function<String, T> getConverterFunction() {
    return converterFunction;
  }

  public Collection<String> getOriginalValues() {
    return originalValues;
  }

  public Collection<T> getConvertedValues() {
    return convertedValues;
  }
}
