package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.resource.FileResource;
import java.util.LinkedHashSet;

public interface DigitalObject extends Entity {

  LinkedHashSet<FileResource> getFileResources();

  void setFileResources(LinkedHashSet<FileResource> fileResources);

  LinkedHashSet<FileResource> addFileResource(FileResource fileResource);
}
