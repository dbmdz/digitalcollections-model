package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.parts.CustomAttributes;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;
import java.util.Objects;

public class EntityImpl extends IdentifiableImpl implements Entity {

  protected CustomAttributes customAttributes;
  protected EntityType entityType;
  protected long refId;

  public EntityImpl() {
    super();
    this.type = IdentifiableType.ENTITY;
  }

  @Override
  public CustomAttributes getCustomAttributes() {
    return customAttributes;
  }

  @Override
  public EntityType getEntityType() {
    return entityType;
  }

  @Override
  public long getRefId() {
    return refId;
  }

  @Override
  public void setCustomAttribute(String attributeName, Object attributeValue) {
    if (customAttributes == null) {
      customAttributes = new CustomAttributes();
    }
    customAttributes.put(attributeName, attributeValue);
  }

  @Override
  public void setCustomAttributes(CustomAttributes customAttributes) {
    this.customAttributes = customAttributes;
  }

  @Override
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }

  @Override
  public void setRefId(long refId) {
    this.refId = refId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EntityImpl)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    EntityImpl entity = (EntityImpl) o;
    return refId == entity.refId &&
        Objects.equals(customAttributes, entity.customAttributes) &&
        entityType == entity.entityType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), customAttributes, entityType, refId);
  }
}
