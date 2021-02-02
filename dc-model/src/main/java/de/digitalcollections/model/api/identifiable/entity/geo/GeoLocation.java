package de.digitalcollections.model.api.identifiable.entity.geo;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.geo.enums.GeoLocationType;

/** A location located on earth. */
public interface GeoLocation extends Entity {

  CoordinateLocation getCoordinateLocation();

  GeoLocationType getGeoLocationType();

  default Double getLatitude() {
    if (getCoordinateLocation() == null) {
      return null;
    }
    return getCoordinateLocation().getLatitude();
  }

  default Double getLongitude() {
    if (getCoordinateLocation() == null) {
      return null;
    }
    return getCoordinateLocation().getLongitude();
  }

  void setCoordinateLocation(CoordinateLocation coordinateLocation);

  void setGeoLocationType(GeoLocationType geoLocationType);
}
