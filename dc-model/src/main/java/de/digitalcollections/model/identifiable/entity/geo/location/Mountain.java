package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A mountain is a large landform that stretches above the surrounding land. see
 * https://www.wikidata.org/wiki/Q8502
 */
public class Mountain extends GeoLocation {

  public Mountain() {
    super();
    init();
  }

  /**
   * @return height of mountain above sea level in meters.
   */
  public int getHeight() {
    return (int) getCustomAttribute("height");
  }

  @Override
  protected void init() {
    super.init();
    this.geoLocationType = GeoLocationType.MOUNTAIN;
  }

  /**
   * @param height height of mountain above sea level in meters
   */
  public void setHeight(int height) {
    setCustomAttribute("height", height);
  }
}
