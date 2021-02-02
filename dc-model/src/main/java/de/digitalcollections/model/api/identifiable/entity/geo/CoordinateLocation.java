package de.digitalcollections.model.api.identifiable.entity.geo;

/**
 * Geocoordinates of a subject. For Earth, please note that only WGS84 coordinating system is
 * supported at the moment. see https://de.wikipedia.org/wiki/Geographische_Koordinaten,
 * https://de.wikipedia.org/wiki/World_Geodetic_System_1984
 */
public interface CoordinateLocation {

  /** @return altitude in meters */
  double getAltitude();

  /** @return latitude in degrees: -90° (Southpole) - 0° (Aequator) - 90° (Northpole) */
  double getLatitude();

  /**
   * @return longitude in degress: 0° (Greenwich, England), East: positve (max. 180°), West:
   *     negative (max 180°)
   */
  double getLongitude();

  /**
   * see https://www.wikidata.org/wiki/Special:EntityData/Q513.json,
   * https://en.wikipedia.org/wiki/Wikipedia:WikiProject_Geographical_coordinates#Precision_guidelines
   *
   * @return precision of coordinates
   */
  double getPrecision();

  public void setLatitude(double d);

  public void setLongitude(double d);
}
