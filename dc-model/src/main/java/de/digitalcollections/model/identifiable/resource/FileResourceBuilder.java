package de.digitalcollections.model.identifiable.resource;

import de.digitalcollections.model.file.MimeType;
import de.digitalcollections.model.identifiable.AbstractIdentifiableBuilder;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.legal.License;
import de.digitalcollections.model.legal.LicenseBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class FileResourceBuilder
    extends AbstractIdentifiableBuilder<FileResource, FileResourceBuilder> {

  @Override
  protected IdentifiableType getIdentifiableType() {
    return IdentifiableType.RESOURCE;
  }

  public FileResourceBuilder withFilename(String filename) {
    identifiable.setFilename(filename);
    return this;
  }

  public FileResourceBuilder withType(FileResourceType fileResourceType) {
    identifiable.setFileResourceType(fileResourceType);
    return this;
  }

  public FileResourceBuilder withMimeType(MimeType mimeType) {
    identifiable.setMimeType(mimeType);
    return this;
  }

  public FileResourceBuilder withHttpBaseUrl(String httpBaseUrl) {
    try {
      identifiable.setHttpBaseUrl(new URL(httpBaseUrl));
    } catch (MalformedURLException e) {
      throw new RuntimeException("Cannot set httpBaseURL=" + httpBaseUrl + ": " + e, e);
    }
    return this;
  }

  public FileResourceBuilder withLicenseOfName(String licenseName) {
    License license =
        new LicenseBuilder()
            .withLabel(Locale.GERMAN, licenseName)
            .withAcronym(licenseName)
            .withUrl("https://localhost/licence/" + licenseName)
            .build();

    identifiable.setLicense(license);
    return this;
  }

  public FileResourceBuilder readwrite() {
    identifiable.setReadonly(false);
    return this;
  }

  public FileResourceBuilder readonly() {
    identifiable.setReadonly(true);
    return this;
  }

  public FileResourceBuilder withSizeInBytes(long size) {
    identifiable.setSizeInBytes(size);
    return this;
  }
}
