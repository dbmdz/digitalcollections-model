package de.digitalcollections.model.identifiable.entity.geo.location;

import de.digitalcollections.model.identifiable.IdentifiableType;
import lombok.experimental.SuperBuilder;

/** A community of any size, in which people live see https://www.wikidata.org/wiki/Q486972 */
@SuperBuilder(buildMethodName = "prebuild")
public class HumanSettlement extends GeoLocation {

  private HumanSettlementType humanSettlementType;

  public HumanSettlement() {
    super();
    this.geoLocationType = GeoLocationType.HUMAN_SETTLEMENT;
  }

  public HumanSettlementType getHumanSettlementType() {
    return humanSettlementType;
  }

  public void setHumanSettlementType(HumanSettlementType humanSettlementType) {
    this.humanSettlementType = humanSettlementType;
  }

  public abstract static class HumanSettlementBuilder<
      C extends HumanSettlement, B extends HumanSettlementBuilder<C, B>>
      extends GeoLocationBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.setType(IdentifiableType.ENTITY);
      c.setGeoLocationType(GeoLocationType.HUMAN_SETTLEMENT);
      setInternalReferences(c);
      return c;
    }
  }
}
