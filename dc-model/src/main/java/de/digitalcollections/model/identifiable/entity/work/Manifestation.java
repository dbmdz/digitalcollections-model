package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.Entity;
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

  /**
   * Text describing the scale of object, e.g. of a map.
   *
   * <p>Examples: "[Ca. 1:820 000]"
   */
  private String statementOfScale;

  public Manifestation() {
    super();
    init();
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

  /**
   * @return Text describing the scale of object, e.g. of a map
   */
  public String getStatementOfScale() {
    return statementOfScale;
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

  /**
   * @param statementOfScale Text describing the scale of object, e.g. of a map
   */
  public void setStatementOfScale(String statementOfScale) {
    this.statementOfScale = statementOfScale;
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
