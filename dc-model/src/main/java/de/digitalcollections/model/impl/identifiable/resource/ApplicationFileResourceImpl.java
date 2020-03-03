package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.ApplicationFileResource;
import de.digitalcollections.model.api.identifiable.resource.enums.FileResourceType;

public class ApplicationFileResourceImpl extends FileResourceImpl
    implements ApplicationFileResource {

  public ApplicationFileResourceImpl() {
    super();
    this.fileResourceType = FileResourceType.APPLICATION;
  }
}
