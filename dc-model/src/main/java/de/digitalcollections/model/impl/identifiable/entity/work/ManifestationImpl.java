package de.digitalcollections.model.impl.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.work.Manifestation;
import de.digitalcollections.model.impl.identifiable.entity.EntityImpl;

public class ManifestationImpl extends EntityImpl implements Manifestation {

  public ManifestationImpl() {
    super();
    this.entityType = EntityType.MANIFESTATION;
  }
}
