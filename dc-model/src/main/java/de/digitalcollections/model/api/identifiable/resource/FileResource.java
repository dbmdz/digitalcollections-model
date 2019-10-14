package de.digitalcollections.model.api.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.legal.License;
import java.net.URI;

/**
 * A FileResource (source) describes any file, regardless of its physical location, used storage
 * technology or required display means (aka "Viewer"). A FileResource can e.g. include an image, a
 * video file, an XML document, or a JSON file.
 */
public interface FileResource extends Identifiable {

  long getSizeInBytes();

  void setSizeInBytes(long sizeInBytes);

  MimeType getMimeType();

  void setMimeType(MimeType mimeType);

  String getFilename();

  void setFilename(String filename);

  String getFilenameExtension();

  License getLicense();

  void setLicense(License license);

  boolean isReadonly();

  void setReadonly(boolean readonly);

  URI getUri();

  void setUri(URI uri);
}
