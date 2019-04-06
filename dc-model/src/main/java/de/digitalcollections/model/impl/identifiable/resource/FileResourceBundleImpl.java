package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.identifiable.resource.FileResourceBundle;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;
import java.util.LinkedHashSet;

public class FileResourceBundleImpl extends IdentifiableImpl implements FileResourceBundle {

  private LinkedHashSet<FileResource> fileResources = new LinkedHashSet<>();

  @Override
  public LinkedHashSet<FileResource> addFileResource(FileResource fileResource) {
    fileResources.add(fileResource);
    return fileResources;
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
