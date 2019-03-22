package de.digitalcollections.model.api.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Identifiable;
import java.util.LinkedHashSet;

public interface FileResourceBundle extends Identifiable {

  LinkedHashSet<FileResource> getFileResources();

  void setFileResources(LinkedHashSet<FileResource> fileResources);

  LinkedHashSet<FileResource> addFileResource(FileResource fileResource);
}
