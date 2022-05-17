package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A country is a distinct region in geography; a broad term that can include political divisions or
 * regions associated with distinct political characteristics. see
 * https://www.wikidata.org/wiki/Q6256
 */
public class Country extends GeoLocation {

  public Country() {
    super();
    init();
  }

  @Override
  protected void init() {
    super.init();
    this.geoLocationType = GeoLocationType.COUNTRY;
  }
}
