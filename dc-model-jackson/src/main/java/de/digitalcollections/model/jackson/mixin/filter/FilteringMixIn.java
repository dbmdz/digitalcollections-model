package de.digitalcollections.model.jackson.mixin.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.filter.Filtering;

@JsonDeserialize(as = Filtering.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface FilteringMixIn {}
