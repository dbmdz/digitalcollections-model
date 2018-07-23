package de.digitalcollections.model.api.identifiable.resource;

import java.net.URI;

/**
 * A FileResource (source) describes any file, regardless of its physical location, used storage technology or required display means (aka "Viewer").
 * A FileResource can e.g. include an image, a video file, an XML document, or a JSON file.
 */
public interface FileResource extends Resource {

  String getFilename();

  String getFilenameExtension();

  void setFilenameExtension(String filenameExtension);

  void setLastModified(long lastModified);

  MimeType getMimeType();

  void setMimeType(MimeType mimeType);

  boolean isReadonly();

  void setReadonly(boolean readonly);

  long getSize();

  void setSize(long size);

  URI getUri();

  void setUri(URI uri);

}
