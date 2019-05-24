package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Version;
import de.digitalcollections.model.api.identifiable.entity.DigitalObject;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import java.util.LinkedHashSet;

public class DigitalObjectImpl extends EntityImpl implements DigitalObject {

  private LinkedHashSet<FileResource> fileResources = new LinkedHashSet<>();

  private Version version;

  public DigitalObjectImpl() {
    super();
    this.entityType = EntityType.DIGITAL_OBJECT;
  }

  @Override
  public LinkedHashSet<FileResource> addFileResource(FileResource fileResource) {
    fileResources.add(fileResource);
    return fileResources;
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
  public LinkedHashSet<FileResource> getFileResources() {
    return fileResources;
  }

  @Override
  public void setFileResources(LinkedHashSet<FileResource> fileResources) {
    this.fileResources = fileResources;
  }
}
