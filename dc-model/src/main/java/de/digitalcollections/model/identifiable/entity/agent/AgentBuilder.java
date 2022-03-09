package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.EntityBuilder;
import de.digitalcollections.model.identifiable.entity.EntityType;

public class AgentBuilder extends EntityBuilder<Agent, AgentBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.AGENT;
  }
}
