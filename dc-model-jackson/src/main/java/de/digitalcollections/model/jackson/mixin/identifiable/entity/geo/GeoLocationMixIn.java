package de.digitalcollections.model.jackson.mixin.identifiable.entity.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.impl.identifiable.entity.geo.GeoLocationImpl;
import de.digitalcollections.model.impl.identifiable.entity.geo.HumanSettlementImpl;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "geoLocationType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  // need to be uppercase (and included as EXISTING_PROPERTY) to reuse enum field values for
  // deserializing:
  @JsonSubTypes.Type(value = GeoLocationImpl.class, name = "GEOLOCATION"),
  @JsonSubTypes.Type(value = HumanSettlementImpl.class, name = "HUMAN_SETTLEMENT"),
})
public interface GeoLocationMixIn {}
