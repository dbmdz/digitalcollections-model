package de.digitalcollections.model.jackson.mixin.identifiable.entity.relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.relation.PredicateImpl;

@JsonDeserialize(as = PredicateImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface PredicateMixIn {}
