package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * An ocean is a large body of saline water (german = "Ozean"). see
 * https://www.wikidata.org/wiki/Q9430 "größte Meere der Erde, Weltmeere"
 */
public class Ocean extends GeoLocation {

  public Ocean() {
    super();
    this.geoLocationType = GeoLocationType.OCEAN;
  }
}
