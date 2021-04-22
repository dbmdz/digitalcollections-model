package de.digitalcollections.model.jackson.mixin.identifiable.entity.geo.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.WRAPPER_OBJECT,
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = GeoLocation.class, name = "geoLocation"),
  @JsonSubTypes.Type(value = HumanSettlement.class, name = "humanSettlement"),
})
public interface GeoLocationMixIn extends EntityMixIn {}
