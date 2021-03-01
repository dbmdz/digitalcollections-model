package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.EntityType;

/** A family (e.g. the "Clintons"). */
public class Family extends Agent {

  public Family() {
    super();
    this.entityType = EntityType.FAMILY;
  }
}
