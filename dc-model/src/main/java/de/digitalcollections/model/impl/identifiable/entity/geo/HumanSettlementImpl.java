package de.digitalcollections.model.impl.identifiable.entity.geo;

import de.digitalcollections.model.api.identifiable.entity.geo.HumanSettlement;
import de.digitalcollections.model.api.identifiable.entity.geo.enums.GeoLocationType;
import de.digitalcollections.model.api.identifiable.entity.geo.enums.HumanSettlementType;

public class HumanSettlementImpl extends GeoLocationImpl implements HumanSettlement {

  private HumanSettlementType humanSettlementType;

  public HumanSettlementImpl() {
    super();
    this.geoLocationType = GeoLocationType.HUMAN_SETTLEMENT;
  }

  @Override
  public HumanSettlementType getHumanSettlementType() {
    return humanSettlementType;
  }

  @Override
  public void setHumanSettlementType(HumanSettlementType humanSettlementType) {
    this.humanSettlementType = humanSettlementType;
  }
}
