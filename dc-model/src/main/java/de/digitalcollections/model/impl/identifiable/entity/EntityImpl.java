package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.EntityType;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;

public class EntityImpl extends IdentifiableImpl implements Entity {

  protected EntityType entityType;

  public EntityImpl() {
    this.type = IdentifiableType.ENTITY;
  }
  
  @Override
  public EntityType getEntityType() {
    return entityType;
  }

  @Override
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }
}
