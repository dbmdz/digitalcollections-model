package de.digitalcollections.model.jackson.mixin.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.filter.FilteringImpl;

@JsonDeserialize(as = FilteringImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface FilteringMixIn {}
