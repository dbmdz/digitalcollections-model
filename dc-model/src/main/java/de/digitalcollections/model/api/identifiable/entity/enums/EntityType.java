package de.digitalcollections.model.api.identifiable.entity.enums;

import de.digitalcollections.model.api.identifiable.entity.Entity;

/** All {@link Entity} types cudami can handle */
public enum EntityType {
  ARTICLE,
  AUDIO,
  BOOK,
  CORPORATE_BODY,
  CORPORATION,
  COLLECTION,
  DIGITAL_OBJECT,
  EVENT,
  EXPRESSION,
  FAMILY,
  IMAGE,
  ITEM,
  MANIFESTATION,
  OBJECT_3D,
  PERSON,
  PLACE,
  PROJECT,
  TOPIC,
  VIDEO,
  WEBSITE,
  WORK;

  @Override
  public String toString() {
    return name();
  }
}
