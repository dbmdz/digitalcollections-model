package de.digitalcollections.model.identifiable.entity.geo.location;

import de.digitalcollections.model.geo.CoordinateLocation;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.EntityType;

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

  public static Builder builder() {
    return new Builder<>();
  }

  public static class Builder<E extends Entity, B extends Entity.Builder> extends Entity.Builder<GeoLocation, B> {

    @Override
    protected EntityType getEntityType() {
      return EntityType.GEOLOCATION;
    }

    protected GeoLocationType getGeoLocationType() {
      return GeoLocationType.GEOLOCATION;
    }

    @Override
    public GeoLocation build() {
      GeoLocation geoLocation = super.build();
      geoLocation.setGeoLocationType(getGeoLocationType());
      return geoLocation;
    }
  }
}
