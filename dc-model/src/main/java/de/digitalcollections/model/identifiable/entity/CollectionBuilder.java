package de.digitalcollections.model.identifiable.entity;

import java.time.LocalDate;

public class CollectionBuilder extends EntityBuilder<Collection, CollectionBuilder> {
  @Override
  protected EntityType getEntityType() {
    return EntityType.COLLECTION;
  }

  public CollectionBuilder withPublicationStart(String publicationStart) {
    identifiable.setPublicationStart(LocalDate.parse(publicationStart));
    return this;
  }
}
