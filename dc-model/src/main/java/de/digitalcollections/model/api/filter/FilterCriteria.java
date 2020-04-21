package de.digitalcollections.model.api.filter;

import com.google.common.reflect.TypeToken;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Filter Criteria Holder
 */
public class FilterCriteria<T extends Comparable> {

  /**
   * Holds the operation {@link FilterOperation}
   */
  private FilterOperation operation;

  /**
   * Table column name
   */
  private String fieldName;

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
   * Holds the filter criteria as type <T>
   */
  private Collection<T> convertedValues;

  // FOR NOT WORKING 2 (get target class)
  private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {
  };
  private final Type type = typeToken.getType(); // or getRawType() to return Class<? super T>

  public Type getType() {
    return type;
  }

  public FilterCriteria() {
  }

  /**
   * Constructor for Filter Criteria with field name, filter string and converter function
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
   * @param fieldName target field the criteria should be used for
   * @param operation operation of criteria
   * @param convertedSingleValue operand of criteria
   * @param minValue minimum value of between operation
   * @param maxValue maximum value of between operation
   * @param convertedValues operand(s) of criteria
   */
  public FilterCriteria(
          String fieldName,
          FilterOperation operation,
          T convertedSingleValue,
          T minValue,
          T maxValue,
          Collection<T> convertedValues) {
    this.operation = operation;
    this.fieldName = fieldName;
    this.convertedSingleValue = convertedSingleValue;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.convertedValues = convertedValues;
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

  public Collection<T> getConvertedValues() {
    return convertedValues;
  }

  public FilterCriteria<T> withFieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }
}
