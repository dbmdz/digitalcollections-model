package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.entity.parts.enums.EntityPartType;

/** A part of an entity. */
public interface EntityPart extends Identifiable {

  EntityPartType getEntityPartType();

  void setEntityPartType(EntityPartType entityPartType);
}
