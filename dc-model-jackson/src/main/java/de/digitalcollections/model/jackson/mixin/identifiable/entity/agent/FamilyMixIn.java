package de.digitalcollections.model.jackson.mixin.identifiable.entity.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.agent.Family;

@JsonDeserialize(as = Family.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("FAMILY")
public interface FamilyMixIn {}
