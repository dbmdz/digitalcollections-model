package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.jackson.mixin.identifiable.IdentifiableMixIn;

@JsonDeserialize(as = Entity.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ENTITY")
public interface EntityMixIn extends IdentifiableMixIn {}
