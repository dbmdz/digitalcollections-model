package de.digitalcollections.model.jackson.mixin.list.filtering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.list.filtering.Filtering;

@JsonDeserialize(as = Filtering.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface FilteringMixIn {}