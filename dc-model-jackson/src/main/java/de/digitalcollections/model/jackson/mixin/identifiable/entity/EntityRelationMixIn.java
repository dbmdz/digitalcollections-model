package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.EntityRelationImpl;

@JsonDeserialize(as = EntityRelationImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ENTITY_RELATION")
public interface EntityRelationMixIn {}
