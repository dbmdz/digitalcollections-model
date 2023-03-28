package de.digitalcollections.model.identifiable.entity.geo.location;

import de.digitalcollections.model.geo.CoordinateLocation;
import de.digitalcollections.model.identifiable.entity.Entity;
import lombok.experimental.SuperBuilder;

/** A location located on earth. */
@SuperBuilder(buildMethodName = "prebuild")
public class GeoLocation extends Entity {

  private CoordinateLocation coordinateLocation;
  protected GeoLocationType geoLocationType;

  public GeoLocation() {
    super();
    init();
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

  @Override
  protected void init() {
    super.init();
    this.geoLocationType = GeoLocationType.GEOLOCATION;
  }

  public void setCoordinateLocation(CoordinateLocation coordinateLocation) {
    this.coordinateLocation = coordinateLocation;
  }

  public void setGeoLocationType(GeoLocationType geoLocationType) {
    this.geoLocationType = geoLocationType;
  }

  public abstract static class GeoLocationBuilder<
          C extends GeoLocation, B extends GeoLocationBuilder<C, B>>
      extends EntityBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }
  }
}
