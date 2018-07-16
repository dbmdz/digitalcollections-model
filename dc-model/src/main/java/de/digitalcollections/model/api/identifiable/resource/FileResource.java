package de.digitalcollections.model.api.identifiable.resource;

import java.net.URI;

/**
 * Eine FileResource (Quelle) beschreibt eine beliebige Datei, unabhaengig von deren physikalischen Speicherort, verwendete Speichertechnologie oder benoetigten Anzeigemittel (aka "Viewer"). Eine
 * FileResource kann z.B. ein Bild, eine Videodatei, eine XML-Dokument oder eine JSON-Datei beinhalten.
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
