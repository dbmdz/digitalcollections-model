package de.digitalcollections.model.identifiable.resource;

import de.digitalcollections.model.file.MimeType;
import de.digitalcollections.model.identifiable.AbstractIdentifiableBuilder;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.legal.License;
import de.digitalcollections.model.legal.LicenseBuilder;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;

public class FileResourceBuilder<F extends FileResource, B extends FileResourceBuilder>
    extends AbstractIdentifiableBuilder<F, B> {

  @Override
  protected IdentifiableType getIdentifiableType() {
    return IdentifiableType.RESOURCE;
  }

  public B withFilename(String filename) {
    identifiable.setFilename(filename);
    return (B) this;
  }

  public B withType(FileResourceType fileResourceType) {
    identifiable.setFileResourceType(fileResourceType);
    return (B) this;
  }

  public B withMimeType(MimeType mimeType) {
    identifiable.setMimeType(mimeType);
    return (B) this;
  }

  public B withHttpBaseUrl(String httpBaseUrl) {
    try {
      identifiable.setHttpBaseUrl(new URL(httpBaseUrl));
    } catch (MalformedURLException e) {
      throw new RuntimeException("Cannot set httpBaseURL=" + httpBaseUrl + ": " + e, e);
    }
    return (B) this;
  }

  public B withLicenseOfName(String licenseName) {
    License license =
        new LicenseBuilder()
            .withLabel(Locale.GERMAN, licenseName)
            .withAcronym(licenseName)
            .withUrl("https://localhost/licence/" + licenseName)
            .build();

    identifiable.setLicense(license);
    return (B) this;
  }

  public B readwrite() {
    identifiable.setReadonly(false);
    return (B) this;
  }

  public B readonly() {
    identifiable.setReadonly(true);
    return (B) this;
  }

  public B withSizeInBytes(long size) {
    identifiable.setSizeInBytes(size);
    return (B) this;
  }

  public B withUri(String uri) {
    try {
      identifiable.setUri(new URI(uri));
    } catch (URISyntaxException e) {
      throw new RuntimeException("Invalid URI=" + uri + ": " + e);
    }
    return (B) this;
  }

}
