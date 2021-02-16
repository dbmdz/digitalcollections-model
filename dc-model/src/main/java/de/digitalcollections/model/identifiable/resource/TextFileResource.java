package de.digitalcollections.model.identifiable.resource;

/** A text file resource. Mimetype starts with "text/". */
public class TextFileResource extends FileResource {

  public TextFileResource() {
    super();
    this.fileResourceType = FileResourceType.TEXT;
  }
}
