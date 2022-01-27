package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.EntityBuilder;
import de.digitalcollections.model.identifiable.entity.EntityType;

public class PersonBuilder extends EntityBuilder<Person, PersonBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.PERSON;
  }
}
