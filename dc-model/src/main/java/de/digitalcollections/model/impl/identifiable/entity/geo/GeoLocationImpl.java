package de.digitalcollections.model.impl.identifiable.entity.geo;

import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.geo.CoordinateLocation;
import de.digitalcollections.model.api.identifiable.entity.geo.GeoLocation;
import de.digitalcollections.model.api.identifiable.entity.geo.enums.GeoLocationType;
import de.digitalcollections.model.impl.identifiable.entity.EntityImpl;

public class GeoLocationImpl extends EntityImpl implements GeoLocation {

  private CoordinateLocation coordinateLocation;
  protected GeoLocationType geoLocationType;

  public GeoLocationImpl() {
    super();
    this.entityType = EntityType.GEOLOCATION;
    this.geoLocationType = GeoLocationType.GEOLOCATION;
  }

  @Override
  public CoordinateLocation getCoordinateLocation() {
    return coordinateLocation;
  }

  @Override
  public GeoLocationType getGeoLocationType() {
    return geoLocationType;
  }

  @Override
  public void setCoordinateLocation(CoordinateLocation coordinateLocation) {
    this.coordinateLocation = coordinateLocation;
  }

  @Override
  public void setGeoLocationType(GeoLocationType geoLocationType) {
    this.geoLocationType = geoLocationType;
  }
}
