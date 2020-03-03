package de.digitalcollections.model.api.identifiable.resource.enums;

public enum FileResourceType {
  APPLICATION,
  AUDIO,
  IMAGE,
  LINKED_DATA,
  TEXT,
  VIDEO;

  @Override
  public String toString() {
    return name();
  }
}
