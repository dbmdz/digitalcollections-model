package de.digitalcollections.model.jackson.mixin.relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.relation.Predicate;

@JsonDeserialize(as = Predicate.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface PredicateMixIn {}
