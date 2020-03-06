package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.TextFileResource;
import de.digitalcollections.model.api.identifiable.resource.enums.FileResourceType;

public class TextFileResourceImpl extends FileResourceImpl implements TextFileResource {

  public TextFileResourceImpl() {
    super();
    this.fileResourceType = FileResourceType.TEXT;
  }
}
