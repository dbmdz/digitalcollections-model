package de.digitalcollections.model.identifiable.entity.geo.location;

import lombok.experimental.SuperBuilder;

/**
 * A sea is a large body of saline water (german = "Meer"). see https://www.wikidata.org/wiki/Q165
 * "die miteinander verbundenen Gewässer der Erde, die die Kontinente umgeben"
 */
@SuperBuilder(buildMethodName = "prebuild")
public class Sea extends GeoLocation {

  public abstract static class SeaBuilder<C extends Sea, B extends SeaBuilder<C, B>>
      extends GeoLocationBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }
  }

  public Sea() {
    super();
    init();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  protected void init() {
    super.init();
    this.geoLocationType = GeoLocationType.SEA;
  }

  @Override
  public String toString() {
    return "Sea [coordinateLocation="
        + coordinateLocation
        + ", geoLocationType="
        + geoLocationType
        + ", name="
        + name
        + ", nameLocalesOfOriginalScripts="
        + nameLocalesOfOriginalScripts
        + ", customAttributes="
        + customAttributes
        + ", navDate="
        + navDate
        + ", refId="
        + refId
        + ", notes="
        + notes
        + ", description="
        + description
        + ", identifiableObjectType="
        + identifiableObjectType
        + ", identifiers="
        + identifiers
        + ", label="
        + label
        + ", localizedUrlAliases="
        + localizedUrlAliases
        + ", previewImage="
        + previewImage
        + ", previewImageRenderingHints="
        + previewImageRenderingHints
        + ", subjects="
        + subjects
        + ", tags="
        + tags
        + ", type="
        + type
        + ", created="
        + created
        + ", lastModified="
        + lastModified
        + ", uuid="
        + uuid
        + "]";
  }
}
