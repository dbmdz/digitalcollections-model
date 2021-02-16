package de.digitalcollections.model.identifiable.entity.geo.location;

/** A community of any size, in which people live see https://www.wikidata.org/wiki/Q486972 */
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
}
