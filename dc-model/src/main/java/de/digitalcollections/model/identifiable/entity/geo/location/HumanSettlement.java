package de.digitalcollections.model.identifiable.entity.geo.location;

import lombok.experimental.SuperBuilder;

/** A community of any size, in which people live see https://www.wikidata.org/wiki/Q486972 */
@SuperBuilder(buildMethodName = "prebuild")
public class HumanSettlement extends GeoLocation {

  private HumanSettlementType humanSettlementType;

  public HumanSettlement() {
    super();
    init();
  }

  public HumanSettlementType getHumanSettlementType() {
    return humanSettlementType;
  }

  @Override
  protected void init() {
    super.init();
    this.geoLocationType = GeoLocationType.HUMAN_SETTLEMENT;
  }

  public void setHumanSettlementType(HumanSettlementType humanSettlementType) {
    this.humanSettlementType = humanSettlementType;
  }

  @Override
  public String toString() {
    return "HumanSettlement{"
        + "humanSettlementType="
        + humanSettlementType
        + ", geoLocationType="
        + geoLocationType
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
        + '}';
  }

  public abstract static class HumanSettlementBuilder<
          C extends HumanSettlement, B extends HumanSettlementBuilder<C, B>>
      extends GeoLocationBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }
  }
}
