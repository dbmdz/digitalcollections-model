package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.production.CreationInfo;

/** Builder to programmatically create a DigitalObject */
public class DigitalObjectBuilder extends EntityBuilder<DigitalObject, DigitalObjectBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.DIGITAL_OBJECT;
  }

  public DigitalObjectBuilder withCreationInfo(CreationInfo creationInfo) {
    identifiable.setCreationInfo(creationInfo);
    return this;
  }

  public DigitalObjectBuilder withParent(DigitalObject parentDigitalObject) {
    identifiable.setParent(parentDigitalObject);
    return this;
  }

  public DigitalObjectBuilder withIdentifier(Identifier identifier) {
    identifiable.addIdentifier(identifier);
    return this;
  }
}
