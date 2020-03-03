package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.api.identifiable.resource.enums.FileResourceType;
import java.net.URI;

public class LinkedDataFileResourceImpl extends FileResourceImpl implements LinkedDataFileResource {

  private URI context;
  private String objectType;

  public LinkedDataFileResourceImpl() {
    super();
    this.fileResourceType = FileResourceType.LINKED_DATA;
  }

  @Override
  public URI getContext() {
    return context;
  }

  @Override
  public void setContext(URI context) {
    this.context = context;
  }

  @Override
  public String getObjectType() {
    return objectType;
  }

  @Override
  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }
}
