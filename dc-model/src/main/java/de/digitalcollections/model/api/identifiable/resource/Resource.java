package de.digitalcollections.model.api.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Identifiable;

public interface Resource extends Identifiable {

  ResourceType getResourceType();

  void setResourceType(ResourceType resourceType);
}
