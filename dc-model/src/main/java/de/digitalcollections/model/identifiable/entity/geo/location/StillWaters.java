package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A natural or man-made body of water. see https://www.wikidata.org/wiki/Q337567 "Stillgewässer;
 * natürliche oder künstlich geschaffene Gewässer"
 */
public class StillWaters extends GeoLocation {

  public StillWaters() {
    super();
    this.geoLocationType = GeoLocationType.STILL_WATERS;
  }
}
