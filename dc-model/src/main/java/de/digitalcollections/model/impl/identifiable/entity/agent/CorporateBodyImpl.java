package de.digitalcollections.model.impl.identifiable.entity.agent;

import de.digitalcollections.model.api.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;

public class CorporateBodyImpl extends AgentImpl implements CorporateBody {

  public CorporateBodyImpl() {
    super();
    this.entityType = EntityType.CORPORATE_BODY;
  }
}
