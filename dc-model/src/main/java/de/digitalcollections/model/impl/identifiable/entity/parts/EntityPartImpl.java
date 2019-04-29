package de.digitalcollections.model.impl.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.entity.parts.EntityPart;
import de.digitalcollections.model.api.identifiable.entity.parts.enums.EntityPartType;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;

public class EntityPartImpl extends IdentifiableImpl implements EntityPart {

  protected EntityPartType entityPartType;

  public EntityPartImpl() {
    super();
    this.type = IdentifiableType.ENTITY_PART;
  }

  @Override
  public EntityPartType getEntityPartType() {
    return entityPartType;
  }

  @Override
  public void setEntityPartType(EntityPartType entityPartType) {
    this.entityPartType = entityPartType;
  }
}
