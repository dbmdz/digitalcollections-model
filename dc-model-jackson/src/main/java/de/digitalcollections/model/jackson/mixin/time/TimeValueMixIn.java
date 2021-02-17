package de.digitalcollections.model.jackson.mixin.time;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.time.TimeValue;

@JsonDeserialize(as = TimeValue.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("TIMEVALUE")
public interface TimeValueMixIn {}
