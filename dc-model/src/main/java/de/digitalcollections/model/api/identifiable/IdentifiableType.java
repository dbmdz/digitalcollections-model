package de.digitalcollections.model.api.identifiable;

/** All {@link Identifiable} top types of this library. */
public enum IdentifiableType {
  ENTITY,
  ENTITY_PART,
  RESOURCE;

  @Override
  public String toString() {
    return name();
  }
}
