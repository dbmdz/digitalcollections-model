package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A deep ravine between cliffs. see https://www.wikidata.org/wiki/Q150784 "Schlucht; tief
 * eingeschnittenes Tal"
 */
public class Canyon extends GeoLocation {

  public Canyon() {
    super();
    init();
  }

  @Override
  protected void init() {
    super.init();
    this.geoLocationType = GeoLocationType.CANYON;
  }
}
