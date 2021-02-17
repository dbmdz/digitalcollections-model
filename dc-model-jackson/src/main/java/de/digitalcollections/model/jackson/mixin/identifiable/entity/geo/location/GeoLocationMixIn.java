package de.digitalcollections.model.jackson.mixin.identifiable.entity.geo.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "geoLocationType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  // need to be uppercase (and included as EXISTING_PROPERTY) to reuse enum field values for
  // deserializing:
  @JsonSubTypes.Type(value = GeoLocation.class, name = "GEOLOCATION"),
  @JsonSubTypes.Type(value = HumanSettlement.class, name = "HUMAN_SETTLEMENT"),
})
public interface GeoLocationMixIn extends EntityMixIn {}
