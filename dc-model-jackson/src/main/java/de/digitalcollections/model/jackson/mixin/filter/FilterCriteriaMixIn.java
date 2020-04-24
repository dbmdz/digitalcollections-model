package de.digitalcollections.model.jackson.mixin.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import de.digitalcollections.model.impl.filter.FilterCriteriaImpl;
import java.util.Collection;

@JsonDeserialize(as = FilterCriteriaImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("FILTERCRITERIA")
public abstract class FilterCriteriaMixIn<T extends Comparable> extends FilterCriteriaImpl<T>
    implements FilterCriteria<T> {

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.CLASS,
      include = JsonTypeInfo.As.PROPERTY,
      property = "className")
  private T value;

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.CLASS,
      include = JsonTypeInfo.As.PROPERTY,
      property = "className")
  private T maxValue;

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.CLASS,
      include = JsonTypeInfo.As.PROPERTY,
      property = "className")
  private T minValue;

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.CLASS,
      include = JsonTypeInfo.As.PROPERTY,
      property = "className")
  private Collection<T> values;

  @JsonCreator
  public FilterCriteriaMixIn(
      @JsonProperty("fieldName") String fieldName,
      @JsonProperty("operation") FilterOperation operation,
      @JsonProperty("value") T value,
      @JsonProperty("minValue") T minValue,
      @JsonProperty("maxValue") T maxValue,
      @JsonProperty("values") Collection<T> values) {
    super(fieldName, operation, value, minValue, maxValue, values);
  }
}
