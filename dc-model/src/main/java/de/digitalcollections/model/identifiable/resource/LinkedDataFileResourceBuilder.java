package de.digitalcollections.model.identifiable.resource;

import java.net.URI;

public class LinkedDataFileResourceBuilder
    extends FileResourceBuilder<LinkedDataFileResource, LinkedDataFileResourceBuilder> {

  public LinkedDataFileResourceBuilder withContext(String context) {
    identifiable.setContext(URI.create(context));
    return this;
  }

  public LinkedDataFileResourceBuilder withObjectType(String objectType) {
    identifiable.setObjectType(objectType);
    return this;
  }
}
