package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import lombok.experimental.SuperBuilder;

/**
 * From https://web.library.yale.edu/cataloging/music/frbr-wemi-music#item:
 *
 * <p>A work is realized by an expression, which is embodied in a manifestation, which is
 * exemplified by an item.
 *
 * <p>An Item is the actual copy of the manifestation that expression takes that is owned by a
 * person or corporate body. It is the only absolutely concrete entity in the FRBR model
 *
 * <p>An item can consist of several distinct physical objects, such as a box set of CDs, or two
 * separately bound volumes with no common sleeve/box that were issued and sold together. Both are
 * considered to be one item.
 *
 * <p>Each copy of Music &amp; Arts 1995 pressing of the recording of Die Zauberflöte by Mozart July
 * 27, 1949 performance by the Konzertvereinigung Wiener Staatsopernchor is an item.
 *
 * <p>Each copy of Sony Classical's 2005 release of the June 10, 14-16, 1955 J.S. Bach's Goldberg
 * variations performed by Glen Gould is an item.
 *
 * <p>Attributes of an item: provenance, location, condition, access restrictions, identifier (if it
 * has one), etc.
 *
 * <p>Dublin Core Fields of an item:
 * https://dublincore.org/resources/userguide/publishing_metadata/#Properties_of_the_legacy_namespace
 * https://www.loc.gov/standards/marcxml/Sandburg/sandburgdc.xml
 *
 * <ul>
 *   <li>title: stored in "label" (may be set without specified locale, but should be set with
 *       locale of language
 *   <li>language
 *   <li>publisher
 *   <li>publicationDate
 *   <li>publicationPlace
 * </ul>
 */
@SuperBuilder(buildMethodName = "prebuild")
public class Item extends Entity {

  private Locale language;
  private String publicationDate;
  private String publicationPlace;
  private String publisher;
  private String version;

  public Item() {
    super();
    init();
  }

  public Locale getLanguage() {
    return language;
  }

  public String getPublicationDate() {
    return publicationDate;
  }

  public String getPublicationPlace() {
    return publicationPlace;
  }

  public String getPublisher() {
    return publisher;
  }

  public LocalizedText getTitle() {
    return getLabel();
  }

  public String getVersion() {
    return version;
  }

  @Override
  protected void init() {
    super.init();
  }

  /**
   * @param language language of item (if text, audio, video, etc.)
   */
  public void setLanguage(Locale language) {
    this.language = language;
  }

  /**
   * http://irsc.libguides.com/MLA:
   *
   * <p>Whether the year, month and year, or complete date is cited depends on the information
   * available, the type of source, and the use of the source. Give the date as shown or use what is
   * most relevant to your use of the source. If the month, day, and year are given, use all three.
   * If only the year is given, that is sufficient.
   *
   * @param publicationDate date of publication
   */
  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

  /**
   * http://irsc.libguides.com/APA/:
   *
   * <p>The place of publication is the "name of the city where the publisher is located." The place
   * can be found on the title page or verso of the title page. Use the first city listed or the
   * city where the publisher's headquarters is located. Follow city names from other countries with
   * the name of the country, e.g. "Frankfurt, Germany"
   *
   * @param publicationPlace place of publication
   */
  public void setPublicationPlace(String publicationPlace) {
    this.publicationPlace = publicationPlace;
  }

  /**
   * http://irsc.libguides.com/MLA:
   *
   * <p>The company or organization primarily responsible for producing the source or making it
   * available is the publisher. For books, the publisher is listed on the title page.
   *
   * @param publisher name of publisher
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public void setTitle(LocalizedText title) {
    setLabel(title);
  }

  public void setTitle(String title) {
    setLabel(title);
  }

  /**
   * http://irsc.libguides.com/MLA:
   *
   * <p>It is not always needed. If different versions of the source exist, use this element to
   * state which version is being cited. Some examples of different versions include editions (e.g.
   * "2nd ed."), director's cuts, and abridged or unabridged versions.
   *
   * @param version version of item
   */
  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
        + "{language="
        + language
        + ", publicationDate='"
        + publicationDate
        + "', publicationPlace='"
        + publicationPlace
        + "', publisher='"
        + publisher
        + "', version='"
        + version
        + ", refId="
        + refId
        + ", created="
        + created
        + ", description="
        + description
        + ", label="
        + label
        + ", lastModified="
        + lastModified
        + ", previewImage="
        + previewImage
        + ", previewImageRenderingHints="
        + previewImageRenderingHints
        + ", type="
        + type
        + "}";
  }

  public abstract static class ItemBuilder<C extends Item, B extends ItemBuilder<C, B>>
      extends EntityBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }
  }
}
