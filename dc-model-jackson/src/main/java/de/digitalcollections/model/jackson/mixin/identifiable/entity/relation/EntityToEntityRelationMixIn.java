package de.digitalcollections.model.jackson.mixin.identifiable.entity.relation;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.relation.EntityToEntityRelation;

@JsonDeserialize(as = EntityToEntityRelation.class)
@JsonTypeName("ENTITY_TO_ENTITY_RELATION")
public interface EntityToEntityRelationMixIn {}
