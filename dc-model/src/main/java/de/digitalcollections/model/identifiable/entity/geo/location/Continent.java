package de.digitalcollections.model.identifiable.entity.geo.location;

/** A continent is a geographically very large land mass. see https://www.wikidata.org/wiki/Q5107 */
public class Continent extends GeoLocation {

  public Continent() {
    super();
    this.geoLocationType = GeoLocationType.CONTINENT;
  }
}
