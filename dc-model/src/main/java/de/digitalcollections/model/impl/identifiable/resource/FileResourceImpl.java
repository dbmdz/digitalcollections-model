package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.identifiable.resource.MimeType;
import de.digitalcollections.model.api.legal.License;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;
import java.net.MalformedURLException;
import java.net.URI;

public class FileResourceImpl extends IdentifiableImpl implements FileResource {

  private String filename;
  private License license;
  private MimeType mimeType;
  private boolean readonly = false;
  private long sizeInBytes;
  private URI uri;

  public FileResourceImpl() {
    super();
    this.type = IdentifiableType.RESOURCE;
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
    if (filename == null) {
      return null;
    } else {
      int lastDotPosition = filename.lastIndexOf(".");
      if (lastDotPosition >= 0 && lastDotPosition < filename.length()) {
        String result = filename.substring(lastDotPosition + 1);
        if (result.trim().length() == 0) {
          return null;
        }
        return result;
      } else {
        return null;
      }
    }
  }

  @Override
  public License getLicense() {
    return license;
  }

  @Override
  public void setLicense(License license) {
    this.license = license;
  }

  @Override
  public long getSizeInBytes() {
    return sizeInBytes;
  }

  @Override
  public void setSizeInBytes(long sizeInBytes) {
    this.sizeInBytes = sizeInBytes;
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
  public MimeType getMimeType() {
    return mimeType;
  }

  @Override
  public void setMimeType(MimeType mimeType) {
    this.mimeType = mimeType;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + ":"
           + "\n{"
           + "\n  uuid=" + String.valueOf(getUuid())
           + ",\n  uri=" + String.valueOf(uri)
           + ",\n  mimetype=" + getMimeType().getTypeName()
           + ",\n  lastModified=" + lastModified
           + "\n}";
  }
}
