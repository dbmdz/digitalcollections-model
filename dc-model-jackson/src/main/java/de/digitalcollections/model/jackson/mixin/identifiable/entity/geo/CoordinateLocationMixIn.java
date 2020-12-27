package de.digitalcollections.model.jackson.mixin.identifiable.entity.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.geo.CoordinateLocationImpl;

@JsonDeserialize(as = CoordinateLocationImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("COORDINATE_LOCATION")
public interface CoordinateLocationMixIn {}
