package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Version;
import de.digitalcollections.model.api.identifiable.entity.DigitalObject;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.legal.License;
import java.util.ArrayList;
import java.util.List;

public class DigitalObjectImpl extends EntityImpl implements DigitalObject {

  private List<FileResource> fileResources = new ArrayList<>();
  private License license;
  private Version version;

  public DigitalObjectImpl() {
    super();
    this.entityType = EntityType.DIGITAL_OBJECT;
  }

  @Override
  public void addFileResource(FileResource fileResource) {
    fileResources.add(fileResource);
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
  public Version getVersion() {
    return version;
  }

  @Override
  public void setVersion(Version version) {
    this.version = version;
  }

  @Override
  public List<FileResource> getFileResources() {
    return fileResources;
  }

  @Override
  public void setFileResources(List<FileResource> fileResources) {
    this.fileResources = fileResources;
  }
}
