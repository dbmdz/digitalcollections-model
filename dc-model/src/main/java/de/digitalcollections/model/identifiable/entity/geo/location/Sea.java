package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A sea is a large body of saline water (german = "Meer"). see https://www.wikidata.org/wiki/Q165
 * "die miteinander verbundenen Gewässer der Erde, die die Kontinente umgeben"
 */
public class Sea extends GeoLocation {

  public Sea() {
    super();
    this.geoLocationType = GeoLocationType.SEA;
  }
}
