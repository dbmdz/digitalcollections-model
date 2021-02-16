package de.digitalcollections.model.identifiable.resource;

import de.digitalcollections.model.file.MimeType;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.legal.License;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

/**
 * A FileResource (source) describes any file, regardless of its physical location, used storage
 * technology or required display means (aka "Viewer"). A FileResource can e.g. include an image, a
 * video file, an XML document, or a JSON file.
 */
public class FileResource extends Identifiable {

  protected FileResourceType fileResourceType;
  private String filename;

  private URL httpBaseUrl;
  private License license;
  private MimeType mimeType;
  private boolean readonly = false;
  private long sizeInBytes;
  private URI uri;

  public FileResource() {
    super();
    this.type = IdentifiableType.RESOURCE;
    this.fileResourceType = FileResourceType.UNDEFINED;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof FileResource) {
      final FileResource other = (FileResource) obj;
      return Objects.equals(this.filename, other.filename)
          && Objects.equals(this.fileResourceType, other.fileResourceType)
          && Objects.equals(this.mimeType, other.mimeType)
          && Objects.equals(this.sizeInBytes, other.sizeInBytes)
          && Objects.equals(this.uri, other.uri);
    }
    return false;
  }

  public FileResourceType getFileResourceType() {
    return fileResourceType;
  }

  public String getFilename() {
    if (filename == null && uri != null) {
      try {
        filename = uri.toURL().getFile();
        if (filename.contains("/")) {
          filename = filename.substring(filename.lastIndexOf('/') + 1);
        }
        if (filename.contains("?")) {
          filename = filename.substring(0, filename.indexOf('?'));
        }
      } catch (MalformedURLException ex) {
        filename = null;
      }
    }
    return filename;
  }

  public String getFilenameExtension() {
    String filename = getFilename();
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

  /**
   * @return a base HTTP url for getting the file resource. Supposed to be extended by additional
   *     URL params.
   */
  public URL getHttpBaseUrl() {
    return httpBaseUrl;
  }

  public License getLicense() {
    return license;
  }

  public MimeType getMimeType() {
    return mimeType;
  }

  public long getSizeInBytes() {
    return sizeInBytes;
  }

  public URI getUri() {
    return this.uri;
  }

  @Override
  public int hashCode() {
    return Objects.hash(filename, fileResourceType, mimeType, sizeInBytes, uri);
  }

  public boolean isReadonly() {
    return this.readonly;
  }

  public void setFileResourceType(FileResourceType fileResourceType) {
    this.fileResourceType = fileResourceType;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setHttpBaseUrl(URL httpBaseUrl) {
    this.httpBaseUrl = httpBaseUrl;
  }

  public void setLicense(License license) {
    this.license = license;
  }

  public void setMimeType(MimeType mimeType) {
    this.mimeType = mimeType;
  }

  public void setReadonly(boolean readonly) {
    this.readonly = readonly;
  }

  public void setSizeInBytes(long sizeInBytes) {
    this.sizeInBytes = sizeInBytes;
  }

  public void setUri(URI uri) {
    this.uri = uri;
  }

  @Override
  public String toString() {
    String mimetypeStr = getMimeType() == null ? null : getMimeType().getTypeName();

    return this.getClass().getSimpleName()
        + ":"
        + "\n{"
        + "\n  uuid="
        + String.valueOf(getUuid())
        + ",\n  uri="
        + String.valueOf(uri)
        + ",\n  mimetype="
        + mimetypeStr
        + ",\n  lastModified="
        + lastModified
        + "\n}";
  }
}
