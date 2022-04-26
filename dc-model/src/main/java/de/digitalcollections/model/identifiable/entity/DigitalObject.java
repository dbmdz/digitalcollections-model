package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.entity.work.Item;
import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.identifiable.versioning.Version;
import de.digitalcollections.model.legal.License;
import de.digitalcollections.model.production.CreationInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * A (cultural) digital object, can be a retro digitization of a physical object or a digital native
 * object.
 *
 * <p>A digital object can be related to an {@link Item item}, and it also be part of a parent
 * digital object.
 */
public class DigitalObject extends Entity {
  // FIXME We need to specify this! private Availablity availablity;

  /** Details about the creation of the digital object: Who created it, when and where. */
  private CreationInfo creationInfo;

  /** Sorted list of file resources like images, audio files etc. */
  private List<FileResource> fileResources = new ArrayList<>(0);
  /** The related item (can be null, if not applicable). */
  private Item item;
  /** licence of the digital object. */
  private License license;

  /**
   * Sorted list of links (with description) to machine readable formats like Marc, RDF, METS or
   * IIIF-Manifest.
   */
  private List<LinkedDataFileResource> linkedDataResources = new ArrayList<>(0);

  /**
   * number of related binary files for the presentation, like scans in a book, photos of an object,
   * audio files for records etc.
   */
  private int numberOfBinaryResources = 0;

  /** The parent digital object, if the current one is an embedded one. */
  private DigitalObject parent;

  /**
   * Sorted list of links (with description and MIME type) to human readable formats like a
   * permalink, OPAC/catalogue page, PDF download, ...
   */
  private List<FileResource> renderingResources = new ArrayList<>(0);

  /** version of the digital object. */
  private Version version;

  /** Default constructor, which also sets the EntityType to {@link EntityType#DIGITAL_OBJECT} */
  public DigitalObject() {
    super();
    this.entityType = EntityType.DIGITAL_OBJECT;
  }

  public void addFileResource(FileResource fileResource) {
    fileResources.add(fileResource);
  }

  /** @return meta information about the creation of the digital object */
  public CreationInfo getCreationInfo() {
    return creationInfo;
  }

  /** @return the sorted list of file resources, like images or audio files */
  public List<FileResource> getFileResources() {
    return fileResources;
  }

  /** @return the item, the digital object belongs to. Otherwise, return null. */
  public Item getItem() {
    return item;
  }

  /** @return the licence for the digital object (not for the metadata!) */
  public License getLicense() {
    return license;
  }

  /** @return the sorted list of links (with description) to machine readable formats */
  public List<LinkedDataFileResource> getLinkedDataResources() {
    return linkedDataResources;
  }

  /** @return the number of binary resources for presentation */
  public int getNumberOfBinaryResources() {
    return numberOfBinaryResources;
  }

  /** @return the parent of the digital object, it available. Otherwise, return null. */
  public DigitalObject getParent() {
    return parent;
  }

  /** @return the sorted list of links (with description and MIME type) to human readable formats */
  public List<FileResource> getRenderingResources() {
    return renderingResources;
  }

  /** @return the version of the digital object */
  public Version getVersion() {
    return version;
  }

  /**
   * Sets the information about the creation of the digital object
   *
   * @param creationInfo the meta information about the creation
   */
  public void setCreationInfo(CreationInfo creationInfo) {
    this.creationInfo = creationInfo;
  }

  /**
   * Sets the sorted list of file resources
   *
   * @param fileResources the sorted list of file resources
   */
  public void setFileResources(List<FileResource> fileResources) {
    this.fileResources = fileResources;
  }

  /**
   * Set the item, the digital object belongs to
   *
   * @param item the item, the digital object belongs to
   */
  public void setItem(Item item) {
    this.item = item;
  }

  /**
   * Sets the licence for the digital object
   *
   * @param license the licence of the digital object
   */
  public void setLicense(License license) {
    this.license = license;
  }

  /**
   * Sets a sorted list of links (with description) to machine readable formats
   *
   * @param linkedDataResources the sorted list of links
   */
  public void setLinkedDataResources(List<LinkedDataFileResource> linkedDataResources) {
    this.linkedDataResources = linkedDataResources;
  }

  /**
   * Sets the number of binary resources for presentation
   *
   * @param numberOfBinaryResources the number of binary resources
   */
  public void setNumberOfBinaryResources(int numberOfBinaryResources) {
    this.numberOfBinaryResources = numberOfBinaryResources;
  }

  /**
   * Sets the parent of the digital object
   *
   * @param parent of the digital object
   */
  public void setParent(DigitalObject parent) {
    this.parent = parent;
  }

  /**
   * Sets the sorted list of links (with description and MIME type) to human readable formats
   *
   * @param renderingResources the sorted list of links
   */
  public void setRenderingResources(List<FileResource> renderingResources) {
    this.renderingResources = renderingResources;
  }

  /**
   * Sets the version of the digital object
   *
   * @param version of the digital object
   */
  public void setVersion(Version version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return "DigitalObject{"
        + "created="
        + created
        + ", description="
        + description
        + ", identifiers="
        + identifiers
        + ", label="
        + label
        + ", lastModified="
        + lastModified
        + ", localizedUrlAliases="
        + localizedUrlAliases
        + ", previewImage="
        + previewImage
        + ", previewImageRenderingHints="
        + previewImageRenderingHints
        + ", item="
        + item
        + ", parent="
        + parent
        + ", fileResources="
        + fileResources
        + ", linkeddataResources="
        + linkedDataResources
        + ", renderingResources="
        + renderingResources
        + ", numberOfBinaryResources="
        + numberOfBinaryResources
        + ", license="
        + license
        + ", version="
        + version
        + ", creationInfo="
        + creationInfo
        + ", customAttributes="
        + customAttributes
        + ", navDate="
        + navDate
        + ", refId="
        + refId
        + '}';
  }

  public static class Builder extends Entity.Builder<DigitalObject, DigitalObject.Builder> {

    @Override
    protected EntityType getEntityType() {
      return EntityType.DIGITAL_OBJECT;
    }

    public Builder withCreationInfo(CreationInfo creationInfo) {
      ((DigitalObject)identifiable).setCreationInfo(creationInfo);
      return this;
    }

    public Builder withParent(DigitalObject parentDigitalObject) {
      ((DigitalObject)identifiable).setParent(parentDigitalObject);
      return this;
    }

    public Builder withIdentifier(Identifier identifier) {
      ((DigitalObject)identifiable).addIdentifier(identifier);
      return this;
    }

    public Builder withLicense(License license) {
      ((DigitalObject)identifiable).setLicense(license);
      return this;
    }

    public Builder withLinkedDataFileResource(
        LinkedDataFileResource linkedDataFileResource) {
      List<LinkedDataFileResource> linkedDataFileResources = ((DigitalObject)identifiable).getLinkedDataResources();
      if (linkedDataFileResources == null) {
        linkedDataFileResources = new ArrayList<>(0);
      }
      linkedDataFileResources.add(linkedDataFileResource);
      ((DigitalObject)identifiable).setLinkedDataResources(linkedDataFileResources);
      return this;
    }

    public Builder withFileResource(FileResource fileResource) {
      List<FileResource> fileResources = ((DigitalObject)identifiable).getFileResources();
      if (fileResources == null) {
        fileResources = new ArrayList<>(0);
      }
      fileResources.add(fileResource);
      ((DigitalObject)identifiable).setFileResources(fileResources);
      return this;
    }

    public Builder withRenderingResource(FileResource renderingResource) {
      List<FileResource> renderingResources = ((DigitalObject)identifiable).getRenderingResources();
      if (renderingResources == null) {
        renderingResources = new ArrayList<>(0);
      }
      renderingResources.add(renderingResource);
      ((DigitalObject)identifiable).setRenderingResources(renderingResources);
      return this;
    }

  }
}
