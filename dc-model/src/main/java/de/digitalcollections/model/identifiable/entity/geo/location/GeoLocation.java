package de.digitalcollections.model.identifiable.entity.geo.location;

import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.identifiable.entity.geo.CoordinateLocation;

/** A location located on earth. */
public class GeoLocation extends Entity {

  private CoordinateLocation coordinateLocation;
  protected GeoLocationType geoLocationType;

  public GeoLocation() {
    super();
    this.entityType = EntityType.GEOLOCATION;
    this.geoLocationType = GeoLocationType.GEOLOCATION;
  }

  public CoordinateLocation getCoordinateLocation() {
    return coordinateLocation;
  }

  public GeoLocationType getGeoLocationType() {
    return geoLocationType;
  }

  public Double getLatitude() {
    if (getCoordinateLocation() == null) {
      return null;
    }
    return getCoordinateLocation().getLatitude();
  }

  public Double getLongitude() {
    if (getCoordinateLocation() == null) {
      return null;
    }
    return getCoordinateLocation().getLongitude();
  }

  public void setCoordinateLocation(CoordinateLocation coordinateLocation) {
    this.coordinateLocation = coordinateLocation;
  }

  public void setGeoLocationType(GeoLocationType geoLocationType) {
    this.geoLocationType = geoLocationType;
  }
}
