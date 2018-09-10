package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.identifiable.resource.ResourceType;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileResourceImpl extends BinaryContentImpl implements FileResource {

  private String filename;
  private String filenameExtension;
  private boolean readonly = false;
  private URI uri;

  public FileResourceImpl() {
    super();
    this.resourceType = ResourceType.FILE;
  }

  @Override
  public String getFilename() {
    if (filename == null && uri != null) {
      try {
        filename = uri.toURL().getFile();
      } catch (MalformedURLException ex) {
        filename = null;
      }
    }
    return filename;
  }

  @Override
  public void setFilename(String filename) {
    this.filename = filename;
  }

  @Override
  public String getFilenameExtension() {
    return filenameExtension;
  }

  @Override
  public void setFilenameExtension(String filenameExtension) {
    this.filenameExtension = filenameExtension;
  }

  @Override
  public URI getUri() {
    return this.uri;
  }

  @Override
  public void setUri(URI uri) {
    this.uri = uri;
  }

  @Override
  public boolean isReadonly() {
    return this.readonly;
  }

  @Override
  public void setReadonly(boolean readonly) {
    this.readonly = readonly;
  }

  @Override
  public String toString() {
    return "ResourceImpl"
            + "\n{"
            + "\n  uuid=" + String.valueOf(getUuid())
            + ",\n  uri=" + String.valueOf(uri)
            + ",\n  mimetype=" + String.valueOf(getMimeType())
            + ",\n  lastModified=" + lastModified
            + "\n}";
  }

  @Override
  public void setLastModified(long lastModified) {
    LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastModified), ZoneId.systemDefault());
    setLastModified(date);
  }
}
