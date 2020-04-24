package de.digitalcollections.model.feign.expander.filter;

import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import feign.Param;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class FilteringToUrlParamsExpander<T extends Comparable> implements Param.Expander {

  @Override
  public String expand(Object filteringObj) {
    if (filteringObj == null) {
      return "";
    }
    Filtering filtering = (Filtering) filteringObj;
    StringBuilder sb = new StringBuilder();
    for (Iterator iterator = filtering.iterator(); iterator.hasNext(); ) {
      FilterCriteria<T> fc = (FilterCriteria<T>) iterator.next();
      FilterOperation filterOperation = fc.getOperation();
      sb.append("&").append(fc.getFieldName()).append("=");

      if (null == filterOperation) {
        sb.append(convertToString(fc.getValue()));
      } else {
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
      }
    }
    String urlParams = sb.toString();
    if (urlParams.endsWith(",")) {
      urlParams = urlParams.substring(0, urlParams.lastIndexOf(","));
    }
    return urlParams;
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
