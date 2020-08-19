package de.digitalcollections.model.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.TimeValueImpl;

@JsonDeserialize(as = TimeValueImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("TIMEVALUE")
public interface TimeValueMixIn {}
