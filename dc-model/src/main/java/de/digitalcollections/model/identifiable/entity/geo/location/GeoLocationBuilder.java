package de.digitalcollections.model.identifiable.entity.geo.location;

import de.digitalcollections.model.identifiable.entity.EntityBuilder;
import de.digitalcollections.model.identifiable.entity.EntityType;

public class GeoLocationBuilder<GL extends GeoLocation, GLB extends GeoLocationBuilder>
    extends EntityBuilder<GeoLocation, GeoLocationBuilder<GeoLocation, GeoLocationBuilder>> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.GEOLOCATION;
  }

  protected GeoLocationType getGeoLocationType() {
    return GeoLocationType.GEOLOCATION;
  }

  @Override
  public GL build() {
    GeoLocation geoLocation = super.build();
    geoLocation.setGeoLocationType(getGeoLocationType());
    return (GL) geoLocation;
  }
}
