package de.digitalcollections.model.impl.identifiable.entity.agent;

import de.digitalcollections.model.api.identifiable.entity.agent.Family;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;

public class FamilyImpl extends AgentImpl implements Family {

  public FamilyImpl() {
    super();
    this.entityType = EntityType.FAMILY;
  }
}
