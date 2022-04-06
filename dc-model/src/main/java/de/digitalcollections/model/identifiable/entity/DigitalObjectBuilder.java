package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.legal.License;
import de.digitalcollections.model.production.CreationInfo;
import java.util.ArrayList;
import java.util.List;

/** Builder to programmatically create a DigitalObject */
public class DigitalObjectBuilder extends EntityBuilder<DigitalObject, DigitalObjectBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.DIGITAL_OBJECT;
  }

  public DigitalObjectBuilder withCreationInfo(CreationInfo creationInfo) {
    identifiable.setCreationInfo(creationInfo);
    return this;
  }

  public DigitalObjectBuilder withParent(DigitalObject parentDigitalObject) {
    identifiable.setParent(parentDigitalObject);
    return this;
  }

  public DigitalObjectBuilder withIdentifier(Identifier identifier) {
    identifiable.addIdentifier(identifier);
    return this;
  }

  public DigitalObjectBuilder withLicense(License license) {
    identifiable.setLicense(license);
    return this;
  }

  public DigitalObjectBuilder withLinkedDataFileResource(
      LinkedDataFileResource linkedDataFileResource) {
    List<LinkedDataFileResource> linkedDataFileResources = identifiable.getLinkedDataResources();
    if (linkedDataFileResources == null) {
      linkedDataFileResources = new ArrayList<>(0);
    }
    linkedDataFileResources.add(linkedDataFileResource);
    identifiable.setLinkedDataResources(linkedDataFileResources);
    return this;
  }

  public DigitalObjectBuilder withFileResource(FileResource fileResource) {
    List<FileResource> fileResources = identifiable.getFileResources();
    if (fileResources == null) {
      fileResources = new ArrayList<>(0);
    }
    fileResources.add(fileResource);
    identifiable.setFileResources(fileResources);
    return this;
  }

  public DigitalObjectBuilder withRenderingResource(FileResource renderingResource) {
    List<FileResource> renderingResources = identifiable.getRenderingResources();
    if (renderingResources == null) {
      renderingResources = new ArrayList<>(0);
    }
    renderingResources.add(renderingResource);
    identifiable.setRenderingResources(renderingResources);
    return this;
  }
}
