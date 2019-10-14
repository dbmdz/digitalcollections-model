package de.digitalcollections.model.api.identifiable.entity.parts.enums;

import de.digitalcollections.model.api.identifiable.entity.parts.EntityPart;

/** All {@link EntityPart} types cudami can handle */
public enum EntityPartType {
  CONTENT_NODE,
  WEBPAGE;

  @Override
  public String toString() {
    return name();
  }
}
