package de.digitalcollections.model.api.identifiable.entity.geo;

import de.digitalcollections.model.api.identifiable.entity.geo.enums.HumanSettlementType;

/** A community of any size, in which people live see https://www.wikidata.org/wiki/Q486972 */
public interface HumanSettlement extends GeoLocation {

  HumanSettlementType getHumanSettlementType();

  void setHumanSettlementType(HumanSettlementType humanSettlementType);
}
