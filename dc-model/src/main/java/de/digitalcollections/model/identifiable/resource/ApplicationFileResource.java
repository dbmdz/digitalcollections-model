package de.digitalcollections.model.identifiable.resource;

/** An application file resource. Mimetype starts with "application/". */
public class ApplicationFileResource extends FileResource {

  public ApplicationFileResource() {
    super();
    this.fileResourceType = FileResourceType.APPLICATION;
  }
}
