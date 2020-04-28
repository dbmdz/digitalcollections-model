package de.digitalcollections.model.feign.encoder.filter;

import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import feign.QueryMapEncoder;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link QueryMapEncoder} encoding a {@link Filtering} into a map of query parameter names and
 * values.
 *
 * @see <a href="https://github.com/OpenFeign/feign#dynamic-query-parameters">Dynamic Query
 *     Parameters</a>
 */
public class FilteringToQueryMapEncoder<T extends Comparable> implements QueryMapEncoder {

  @Override
  public Map<String, Object> encode(Object object) {
    if (object == null) {
      return null;
    }
    Map<String, Object> queryMap = new HashMap<>();

    Filtering filtering = (Filtering) object;
    for (FilterCriteria<T> fc : filtering) {
      FilterOperation filterOperation = fc.getOperation();
      String fieldName = fc.getFieldName();
      if (null == filterOperation) {
        queryMap.put(fieldName, convertToString(fc.getValue()));
      } else {
        StringBuilder sb = new StringBuilder();
        sb.append(filterOperation.toString()).append(":");
        // All other operation
        switch (filterOperation) {
          case BETWEEN:
            // For operation 'btn'
            if (fc.getMinValue() == null || fc.getMaxValue() == null) {
              throw new IllegalArgumentException("For 'btn' operation two values are expected");
            } else {
              // Convert
              T minValue = fc.getMinValue();
              T maxValue = fc.getMaxValue();
              sb.append(convertToString(minValue)).append(",").append(convertToString(maxValue));
            }
            break;
          case IN:
          case NOT_IN:
            // For 'in' or 'nin' operation
            for (T value : fc.getValues()) {
              sb.append(convertToString(value)).append(",");
            }
            break;
          default:
            // All other operation
            sb.append(convertToString(fc.getValue()));
            break;
        }
        String paramValue = sb.toString();
        if (paramValue.endsWith(",")) {
          paramValue = paramValue.substring(0, paramValue.lastIndexOf(","));
        }
        queryMap.put(fieldName, paramValue);
      }
    }
    return queryMap;
  }

  private String convertToString(T value) {
    if (value == null) {
      return "";
    }
    if (value instanceof LocalDate) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      return ((ChronoLocalDate) value).format(formatter);
    }
    return value.toString();
  }
}
