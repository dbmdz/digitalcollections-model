package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.entity.work.Item;
import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.identifiable.versioning.Version;
import de.digitalcollections.model.legal.License;
import de.digitalcollections.model.production.CreationInfo;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A (cultural) digital object, can be a retro digitization of a physical object or a digital native
 * object.
 *
 * <p>A digital object can be related to an {@link Item item}, and it also be part of a parent
 * digital object.
 */
public class DigitalObject extends Entity {

  /** The related item (can be null, if not applicable). */
  private Item item;

  /** The parent digital object, if the current one is an embedded one. */
  private DigitalObject parent;

  /** Sorted list of file resources like images, audio files etc. */
  private ArrayList<FileResource> fileResources = new ArrayList<>();

  /**
   * Sorted list of links (with description) to machine readable formats like Marc, RDF, METS or
   * IIIF-Manifest.
   */
  private ArrayList<LinkedDataFileResource> downloadResources = new ArrayList<>();

  /**
   * Sorted list of links (with description and MIME type) to human readable formats like a
   * permalink, OPAC/catalogue page, PDF download, ...
   */
  private ArrayList<LinkedDataFileResource> renderingResources = new ArrayList<>();

  /**
   * number of related binary files for the presentation, like scans in a book, photos of an object,
   * audio files for records etc.
   */
  private int numberOfBinaryResources = 0;

  /** licence of the digital object. */
  private License license;

  /** version of the digital object. */
  private Version version;

  // FIXME We need to specify this! private Availablity availablity;

  /** Details about the creation of the digital object: Who created it, when and where. */
  private CreationInfo creationInfo;

  /** A "navigable" date, required when you need to the display the digital object on a timeline. */
  private LocalDate navDate;

  /** Default constructor, which also sets the EntityType to {@link EntityType#DIGITAL_OBJECT} */
  public DigitalObject() {
    super();
    this.entityType = EntityType.DIGITAL_OBJECT;
  }

  /** @return the item, the digital object belongs to. Otherwise, return null. */
  public Item getItem() {
    return item;
  }

  /**
   * Set the item, the digital object belongs to
   *
   * @param item the item, the digital object belongs to
   */
  public void setItem(Item item) {
    this.item = item;
  }

  /** @return the parent of the digital object, it available. Otherwise, return null. */
  public DigitalObject getParent() {
    return parent;
  }

  /**
   * Sets the parent of the digital object
   *
   * @param parent of the digital object
   */
  public void setParent(DigitalObject parent) {
    this.parent = parent;
  }

  /** @return the sorted list of file resources, like images or audio files */
  public ArrayList<FileResource> getFileResources() {
    return fileResources;
  }

  /**
   * Sets the sorted list of file resources
   *
   * @param fileResources the sorted list of file resources
   */
  public void setFileResources(ArrayList<FileResource> fileResources) {
    this.fileResources = fileResources;
  }

  /** @return the sorted list of links (with description) to machine readable formats */
  public ArrayList<LinkedDataFileResource> getDownloadResources() {
    return downloadResources;
  }

  /**
   * Sets a sorted list of links (with description) to machine readable formats
   *
   * @param downloadResources the sorted list of links
   */
  public void setDownloadResources(ArrayList<LinkedDataFileResource> downloadResources) {
    this.downloadResources = downloadResources;
  }

  /** @return the sorted list of links (with description and MIME type) to human readable formats */
  public ArrayList<LinkedDataFileResource> getRenderingResources() {
    return renderingResources;
  }

  /**
   * Sets the sorted list of links (with description and MIME type) to human readable formats
   *
   * @param renderingResources the sorted list of links
   */
  public void setRenderingResources(ArrayList<LinkedDataFileResource> renderingResources) {
    this.renderingResources = renderingResources;
  }

  /** @return the licence for the digital object (not for the metadata!) */
  public License getLicense() {
    return license;
  }

  /**
   * Sets the licence for the digital object
   *
   * @param license the licence of the digital object
   */
  public void setLicense(License license) {
    this.license = license;
  }

  /** @return the version of the digital object */
  public Version getVersion() {
    return version;
  }

  /**
   * Sets the version of the digital object
   *
   * @param version of the digital object
   */
  public void setVersion(Version version) {
    this.version = version;
  }

  /** @return the number of binary resources for presentation */
  public int getNumberOfBinaryResources() {
    return numberOfBinaryResources;
  }

  /**
   * Sets the number of binary resources for presentation
   *
   * @param numberOfBinaryResources the number of binary resources
   */
  public void setNumberOfBinaryResources(int numberOfBinaryResources) {
    this.numberOfBinaryResources = numberOfBinaryResources;
  }

  /** @return meta information about the creation of the digital object */
  public CreationInfo getCreationInfo() {
    return creationInfo;
  }

  /**
   * Sets the information about the creation of the digital object
   *
   * @param creationInfo the meta information about the creation
   */
  public void setCreationInfo(CreationInfo creationInfo) {
    this.creationInfo = creationInfo;
  }

  /** @return a date for "navigation" purposes, e.g. a timeline */
  public LocalDate getNavDate() {
    return navDate;
  }

  /**
   * Sets the "navigation" date
   *
   * @param navDate the "navigation" date
   */
  public void setNavDate(LocalDate navDate) {
    this.navDate = navDate;
  }

  @Override
  public String toString() {
    return "DigitalObject{"
        + "item="
        + item
        + ", parent="
        + parent
        + ", fileResources="
        + fileResources
        + ", downloadResources="
        + downloadResources
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
        + ", navDate="
        + navDate
        + '}';
  }
}
