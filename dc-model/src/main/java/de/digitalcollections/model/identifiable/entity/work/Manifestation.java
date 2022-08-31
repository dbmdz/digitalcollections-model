package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.semantic.Subject;
import de.digitalcollections.model.time.LocalDateRange;
import de.digitalcollections.model.time.TimeValueRange;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import lombok.experimental.SuperBuilder;

/**
 * From https://web.library.yale.edu/cataloging/music/frbr-wemi-music#work:
 *
 * <p>A work is realized by an expression, which is embodied in a manifestation, which is
 * exemplified by an item.
 *
 * <p>A Manifestation is the physical embodiment (i.e., publication) of an expression of a work that
 * is produced by a person or corporate body.° A publication of an expression is called a
 * manifestation
 *
 * <p>Attributes of a manifestation: title, statement of responsibility, edition, imprint (place,
 * publisher, date), form/extent and dimensions of carrier, terms of availability, mode of access,
 * identifier (if it has one), etc. For sound recordings: playing speed, groove width, kind of
 * cutting, tape configuration, kind of sound, special reproduction characteristic
 *
 * <p>Music can be performed, but only when it is recorded is there a manifestation Work: J.S.
 * Bach's Goldberg variations Expression: June 10, 14-16, 1955 performance by Glen Gould
 * Manifestation 1: the recording on a phonograph record Manifestation 2: a re-release on a compact
 * disc Manifestation 3: a digitization on an MP3 file
 */
@SuperBuilder(buildMethodName = "prebuild")
public class Manifestation extends Entity {

  /**
   * Text describing amount of material or content of manifestation.
   *
   * <p>Examples: "37 Seiten", "1 ungezähltes Blatt Bildtafel, 108 Seiten", "1 Partitur (39
   * Seiten)", "V, 64 S., [12] Bl.", "1 Buchdeckel"
   */
  private String composition;

  /**
   * Text describing physical dimensions of object.
   *
   * <p>Examples: "29,2 x 76,9 x 2,8 cm", "8°", "4", "42 x 31 cm"
   */
  private String dimensions;

  private Set<ExpressionType> expressionTypes;
  private List<Involvement> involvements;
  private Locale language;
  private String manufacturingType;
  private Set<String> mediaTypes;
  private Set<Locale> otherLanguages;
  private Manifestation parent;
  private List<Publication> publications;
  private String publishingDatePresentation;
  private LocalDateRange publishingDateRange;
  private TimeValueRange publishingTimeValueRange;
  /**
   * Text describing the scale of object, e.g. of a map.
   *
   * <p>Examples: "[Ca. 1:820 000]"
   */
  private String scale;

  private Set<Series> series;
  private String sortKey;

  private Set<Subject> subjects;
  private List<Title> titles;
  private String version;
  private Work work;

  public Manifestation() {
    super();
  }

  /**
   * @return Text describing amount of material or content of manifestation.
   */
  public String getComposition() {
    return composition;
  }

  /**
   * @return Text describing physical dimensions of object
   */
  public String getDimensions() {
    return dimensions;
  }

  public Set<ExpressionType> getExpressionTypes() {
    return expressionTypes;
  }

  public List<Involvement> getInvolvements() {
    return involvements;
  }

  public Locale getLanguage() {
    return language;
  }

  public String getManufacturingType() {
    return manufacturingType;
  }

  public Set<String> getMediaTypes() {
    return mediaTypes;
  }

  public Set<Locale> getOtherLanguages() {
    return otherLanguages;
  }

  public Manifestation getParent() {
    return parent;
  }

  public List<Publication> getPublications() {
    return publications;
  }

  public String getPublishingDatePresentation() {
    return publishingDatePresentation;
  }

  public LocalDateRange getPublishingDateRange() {
    return publishingDateRange;
  }

  public TimeValueRange getPublishingTimeValueRange() {
    return publishingTimeValueRange;
  }
  /**
   * @return Text describing the scale of object, e.g. of a map
   */
  public String getScale() {
    return scale;
  }

  public Set<Series> getSeries() {
    return series;
  }

  public String getSortKey() {
    return sortKey;
  }

  public Set<Subject> getSubjects() {
    return subjects;
  }

  public List<Title> getTitles() {
    return titles;
  }

  public String getVersion() {
    return version;
  }

  public Work getWork() {
    return work;
  }

  @Override
  protected void init() {
    super.init();
  }

  /**
   * @param composition Text describing amount of material or content of manifestation.
   */
  public void setComposition(String composition) {
    this.composition = composition;
  }

  /**
   * @param dimensions Text describing physical dimensions of object
   */
  public void setDimensions(String dimensions) {
    this.dimensions = dimensions;
  }

  public void setExpressionTypes(Set<ExpressionType> expressionTypes) {
    this.expressionTypes = expressionTypes;
  }

  public void setInvolvements(List<Involvement> involvements) {
    this.involvements = involvements;
  }

  public void setLanguage(Locale language) {
    this.language = language;
  }

  public void setManufacturingType(String manufacturingType) {
    this.manufacturingType = manufacturingType;
  }

  public void setMediaTypes(Set<String> mediaTypes) {
    this.mediaTypes = mediaTypes;
  }

  public void setOtherLanguages(Set<Locale> otherLanguages) {
    this.otherLanguages = otherLanguages;
  }

  public void setParent(Manifestation parent) {
    this.parent = parent;
  }

  public void setPublications(List<Publication> publications) {
    this.publications = publications;
  }

  public void setPublishingDatePresentation(String publishingDatePresentation) {
    this.publishingDatePresentation = publishingDatePresentation;
  }

  public void setPublishingDateRange(LocalDateRange publishingDateRange) {
    this.publishingDateRange = publishingDateRange;
  }

  public void setPublishingTimeValueRange(TimeValueRange publishingTimeValueRange) {
    this.publishingTimeValueRange = publishingTimeValueRange;
  }
  /**
   * @param scale Text describing the scale of object, e.g. of a map
   */
  public void setScale(String scale) {
    this.scale = scale;
  }

  public void setSeries(Set<Series> series) {
    this.series = series;
  }

  public void setSortKey(String sortKey) {
    this.sortKey = sortKey;
  }

  public void setSubjects(Set<Subject> subjects) {
    this.subjects = subjects;
  }

  public void setTitles(List<Title> titles) {
    this.titles = titles;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setWork(Work work) {
    this.work = work;
  }

  public abstract static class ManifestationBuilder<
          C extends Manifestation, B extends ManifestationBuilder<C, B>>
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
