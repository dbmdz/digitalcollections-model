package de.digitalcollections.model.identifiable.entity;

/** Builder to programmatically create a DigitalObject */
public class DigitalObjectBuilder extends EntityBuilder<DigitalObject, DigitalObjectBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.DIGITAL_OBJECT;
  }
}
