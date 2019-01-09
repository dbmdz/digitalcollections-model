package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;

/**
 * An entity.
 */
public interface Entity extends Identifiable {

  EntityType getEntityType();

  void setEntityType(EntityType entityType);
}
