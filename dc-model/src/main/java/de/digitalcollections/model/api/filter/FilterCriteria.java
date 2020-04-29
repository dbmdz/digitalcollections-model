package de.digitalcollections.model.api.filter;

import de.digitalcollections.model.api.filter.enums.FilterOperation;
import java.util.Collection;

/**
 * Filter Criteria Container. A filter criteria is a composition of
 *
 * <ul>
 *   <li>a field name being target of filter operation
 *   <li>a filter operation
 *   <li>one ore more filter values to be used for filtering operation
 * </ul>
 *
 * References:
 *
 * @see <a href="https://github.com/vijjayy81/spring-boot-jpa-rest-demo-filter-paging-sorting">An
 *     example application using Spring boot MVC, Spring Data JPA with the ability to do filter,
 *     pagination and sorting.</a>
 * @param <T> type of field-data to be filtered (operand), e.g. Date, LocalDate, Long, etc.
 */
public interface FilterCriteria<T extends Comparable> {

  /** @return value of a single value operation */
  T getValue();

  /** @return values of a multi value operation of field type T */
  Collection<T> getValues();

  /** @return field name being target of filter operation */
  String getFieldName();

  /** @return maximum value - applicable only for {@link FilterOperation#BETWEEN} */
  T getMaxValue();

  /** @return minimum value - applicable only for {@link FilterOperation#BETWEEN} */
  T getMinValue();

  /** @return the filter operation. available operations see {@link FilterOperation} */
  FilterOperation getOperation();

  /** @param operation the filter operation. available operations see {@link FilterOperation} */
  void setOperation(FilterOperation operation);

  /** @param fieldName field name being target of filter operation */
  void setFieldName(String fieldName);

  /** @param maxValue maximum value - applicable only for {@link FilterOperation#BETWEEN} */
  void setMaxValue(T maxValue);

  /** @param minValue minimum value - applicable only for {@link FilterOperation#BETWEEN} */
  void setMinValue(T minValue);

  /** @param value value of a single value operation */
  void setValue(T value);

  /** @param values values of a multi value operation of field type T */
  void setValues(Collection<T> values);
}
