package de.digitalcollections.model.api.identifiable.entity.geo;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.geo.enums.GeoLocationType;

/** A location located on earth. */
public interface GeoLocation extends Entity {

  CoordinateLocation getCoordinateLocation();

  void setCoordinateLocation(CoordinateLocation coordinateLocation);

  GeoLocationType getGeoLocationType();

  void setGeoLocationType(GeoLocationType geoLocationType);
}
