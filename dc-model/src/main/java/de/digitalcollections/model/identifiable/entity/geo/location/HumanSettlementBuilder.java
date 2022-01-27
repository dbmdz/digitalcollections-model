package de.digitalcollections.model.identifiable.entity.geo.location;

import de.digitalcollections.model.identifiable.entity.EntityBuilder;
import de.digitalcollections.model.identifiable.entity.EntityType;

public class HumanSettlementBuilder extends EntityBuilder<HumanSettlement, HumanSettlementBuilder> {
  @Override
  protected EntityType getEntityType() {
    return EntityType.GEOLOCATION;
  }

  protected GeoLocationType getGeoLocationType() {
    return GeoLocationType.HUMAN_SETTLEMENT;
  }

  @Override
  public HumanSettlement build() {
    HumanSettlement humanSettlement = super.build();
    humanSettlement.setGeoLocationType(getGeoLocationType());
    return humanSettlement;
  }
}
