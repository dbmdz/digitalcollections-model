package de.digitalcollections.model.identifiable.entity.geo.location;

import de.digitalcollections.model.identifiable.entity.EntityBuilder;
import de.digitalcollections.model.identifiable.entity.EntityType;

public class GeoLocationBuilder extends EntityBuilder<GeoLocation, GeoLocationBuilder> {

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
