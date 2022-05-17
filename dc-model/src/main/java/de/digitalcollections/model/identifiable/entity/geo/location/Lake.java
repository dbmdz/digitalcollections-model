package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A body of relatively still water, localized in a basin. see https://www.wikidata.org/wiki/Q23397
 * "See; von Land umgebenes Stillgewässer mit oder ohne Zu- und Abfluss"
 */
public class Lake extends GeoLocation {

  public Lake() {
    super();
    init();
  }

  @Override
  protected void init() {
    super.init();
    this.geoLocationType = GeoLocationType.LAKE;
  }
}
