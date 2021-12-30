package de.digitalcollections.model.identifiable.entity.geo.location;

/** A natural watercourse. see https://www.wikidata.org/wiki/Q4022 "natürliches Fließgewässer" */
public class River extends GeoLocation {

  public River() {
    super();
    this.geoLocationType = GeoLocationType.RIVER;
  }
}
