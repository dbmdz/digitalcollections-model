package de.digitalcollections.model.identifiable.entity.geo;

/**
 * Geocoordinates of a subject. For Earth, please note that only WGS84 coordinating system is
 * supported at the moment. see https://de.wikipedia.org/wiki/Geographische_Koordinaten,
 * https://de.wikipedia.org/wiki/World_Geodetic_System_1984
 */
public class CoordinateLocation {

  private double altitude;
  private double latitude;
  private double longitude;
  private double precision;

  public CoordinateLocation() {}

  public CoordinateLocation(Double latitude, Double longitude, Double altitude, Double precision) {
    if (latitude != null) {
      this.latitude = latitude;
    }
    if (longitude != null) {
      this.longitude = longitude;
    }
    if (altitude != null) {
      this.altitude = altitude;
    }
    if (precision != null) {
      this.precision = precision;
    }
  }

  /** @return altitude in meters */
  public double getAltitude() {
    return altitude;
  }

  /** @return latitude in degrees: -90° (Southpole) - 0° (Aequator) - 90° (Northpole) */
  public double getLatitude() {
    return latitude;
  }

  /**
   * @return longitude in degress: 0° (Greenwich, England), East: positve (max. 180°), West:
   *     negative (max 180°)
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * see https://www.wikidata.org/wiki/Special:EntityData/Q513.json,
   * https://en.wikipedia.org/wiki/Wikipedia:WikiProject_Geographical_coordinates#Precision_guidelines
   *
   * @return precision of coordinates
   */
  public double getPrecision() {
    return precision;
  }

  public void setAltitude(double altitude) {
    this.altitude = altitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public void setPrecision(double precision) {
    this.precision = precision;
  }
}
