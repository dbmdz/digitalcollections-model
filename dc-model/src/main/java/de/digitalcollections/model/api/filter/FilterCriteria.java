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

  /** @param fieldName field name being target of filter operation */
  void setFieldName(String fieldName);
}
