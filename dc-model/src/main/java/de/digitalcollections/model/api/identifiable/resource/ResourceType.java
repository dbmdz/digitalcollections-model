package de.digitalcollections.model.api.identifiable.resource;

/**
 * All {@link Resource} types cudami can handle
 */
public enum ResourceType {
  BINARY_CONTENT, FILE, IIIF_IMAGE, IIIF_MANIFEST;

  @Override
  public String toString() {
    return name();
  }
}
