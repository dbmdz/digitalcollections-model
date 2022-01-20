package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.AbstractIdentifiableBuilder;
import de.digitalcollections.model.identifiable.IdentifiableType;
import java.time.LocalDate;

public class EntityBuilder<E extends Entity, B extends EntityBuilder>
    extends AbstractIdentifiableBuilder<E, B> {

  protected EntityType getEntityType() {
    return EntityType.ENTITY;
  }

  @Override
  protected IdentifiableType getIdentifiableType() {
    return IdentifiableType.ENTITY;
  }

  @Override
  public E build() {
    Entity e = super.build();
    e.setEntityType(getEntityType());
    return (E) e;
  }

  public B withCustomAttribute(String key, Object value) {
    identifiable.setCustomAttribute(key, value);
    return (B) this;
  }

  public B withNavDate(String navDate) {
    identifiable.setNavDate(LocalDate.parse(navDate));
    return (B) this;
  }

  public B withRefId(long refId) {
    identifiable.setRefId(refId);
    return (B) this;
  }
}
