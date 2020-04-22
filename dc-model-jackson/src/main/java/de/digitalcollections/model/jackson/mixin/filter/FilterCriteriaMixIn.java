package de.digitalcollections.model.jackson.mixin.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import de.digitalcollections.model.impl.filter.FilterCriteriaImpl;
import java.util.Collection;

@JsonDeserialize(as = FilterCriteriaImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class FilterCriteriaMixIn<T extends Comparable> {

  @JsonCreator
  public FilterCriteriaMixIn(
      @JsonProperty("fieldName") String fieldName,
      @JsonProperty("operation") FilterOperation operation,
      @JsonProperty("value") T value,
      @JsonProperty("minValue") T minValue,
      @JsonProperty("maxValue") T maxValue,
      @JsonProperty("values") Collection<T> values) {}
}
