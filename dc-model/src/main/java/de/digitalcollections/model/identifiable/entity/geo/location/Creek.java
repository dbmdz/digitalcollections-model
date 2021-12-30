package de.digitalcollections.model.identifiable.entity.geo.location;

/** A small stream. see https://www.wikidata.org/wiki/Q63565252 "Bach; kleiner Fluss" */
public class Creek extends GeoLocation {

  public Creek() {
    super();
    this.geoLocationType = GeoLocationType.CREEK;
  }
}
