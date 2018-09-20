package de.digitalcollections.model.api.identifiable;

/**
 * All {@link Identifiable} types cudami can handle
 */
public enum IdentifiableType {
  ENTITY, ENTITY_PART, RESOURCE;

  @Override
  public String toString() {
    return name();
  }
}
