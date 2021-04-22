package de.digitalcollections.model.jackson.mixin.identifiable.entity.relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.relation.EntityRelation;

@JsonDeserialize(as = EntityRelation.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("entityRelation")
public interface EntityRelationMixIn {}
