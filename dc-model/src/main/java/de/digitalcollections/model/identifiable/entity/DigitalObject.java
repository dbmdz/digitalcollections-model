package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.versioning.Version;
import de.digitalcollections.model.legal.License;
import java.util.ArrayList;
import java.util.List;

/**
 * A (cultural) digital object, can be a retro digitization of a physical object or a digital native
 * object.
 */
public class DigitalObject extends Entity {

  private List<FileResource> fileResources = new ArrayList<>();
  private License license;
  private Version version;

  public DigitalObject() {
    super();
    this.entityType = EntityType.DIGITAL_OBJECT;
  }

  public void addFileResource(FileResource fileResource) {
    fileResources.add(fileResource);
  }

  public List<FileResource> getFileResources() {
    return fileResources;
  }

  public License getLicense() {
    return license;
  }

  public Version getVersion() {
    return version;
  }

  public void setFileResources(List<FileResource> fileResources) {
    this.fileResources = fileResources;
  }

  public void setLicense(License license) {
    this.license = license;
  }

  public void setVersion(Version version) {
    this.version = version;
  }
}
