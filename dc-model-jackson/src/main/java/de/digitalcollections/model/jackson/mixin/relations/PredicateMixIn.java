package de.digitalcollections.model.jackson.mixin.relations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.relations.PredicateImpl;

@JsonDeserialize(as = PredicateImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface PredicateMixIn {}
