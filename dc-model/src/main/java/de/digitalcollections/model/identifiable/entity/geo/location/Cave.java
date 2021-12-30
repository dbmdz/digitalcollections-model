package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A natural underground space large enough for a human to enter. see
 * https://www.wikidata.org/wiki/Q35509 "Höhle; natürlich entstandener unterirdischer Hohlraum"
 */
public class Cave extends GeoLocation {

  public Cave() {
    super();
    this.geoLocationType = GeoLocationType.CAVE;
  }
}
