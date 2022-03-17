package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.EntityBuilder;
import de.digitalcollections.model.identifiable.entity.EntityType;

public class ItemBuilder extends EntityBuilder<Item, ItemBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.ITEM;
  }
}
