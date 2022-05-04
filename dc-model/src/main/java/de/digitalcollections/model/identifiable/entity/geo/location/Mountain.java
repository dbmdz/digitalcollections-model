package de.digitalcollections.model.identifiable.entity.geo.location;

/**
 * A mountain is a large landform that stretches above the surrounding land. see
 * https://www.wikidata.org/wiki/Q8502
 */
public class Mountain extends GeoLocation {

  public Mountain() {
    super();
    this.geoLocationType = GeoLocationType.MOUNTAIN;
  }

  /**
   * @return height of mountain above sea level in meters.
   */
  public int getHeight() {
    return (int) getCustomAttribute("height");
  }

  /**
   * @param height height of mountain above sea level in meters
   */
  public void setHeight(int height) {
    setCustomAttribute("height", height);
  }
}
