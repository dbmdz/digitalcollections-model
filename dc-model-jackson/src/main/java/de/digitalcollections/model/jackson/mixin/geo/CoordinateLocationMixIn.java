package de.digitalcollections.model.jackson.mixin.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.geo.CoordinateLocation;

@JsonDeserialize(as = CoordinateLocation.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("COORDINATE_LOCATION")
public interface CoordinateLocationMixIn {}
