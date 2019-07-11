package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Version;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.legal.License;
import java.util.LinkedHashSet;

/**
 * A (cultural) digital object, can be a retro digitization of a physical object or a digital native object.
 */
public interface DigitalObject extends Entity {

  LinkedHashSet<FileResource> getFileResources();

  void setFileResources(LinkedHashSet<FileResource> fileResources);

  LinkedHashSet<FileResource> addFileResource(FileResource fileResource);

  License getLicense();

  void setLicense(License license);

  Version getVersion();

  void setVersion(Version version);
}
