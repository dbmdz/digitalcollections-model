package de.digitalcollections.model.identifiable.entity;

/** All entity types cudami can handle */
public enum EntityType {
  ARTICLE,
  AUDIO,
  BOOK,
  CORPORATE_BODY,
  COLLECTION,
  DIGITAL_OBJECT,
  EVENT,
  EXPRESSION,
  FAMILY,
  GEOLOCATION,
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
