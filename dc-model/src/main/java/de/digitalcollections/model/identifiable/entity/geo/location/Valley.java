package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A low area between hills, often with a river running through it. see
 * https://www.wikidata.org/wiki/Q165 "Tal; langgestreckte, mit mindestens einem Abfluss offene
 * Hohlform in der Landschaft"
 */
public class Valley extends GeoLocation {

  public Valley() {
    super();
    this.geoLocationType = GeoLocationType.VALLEY;
  }
}
