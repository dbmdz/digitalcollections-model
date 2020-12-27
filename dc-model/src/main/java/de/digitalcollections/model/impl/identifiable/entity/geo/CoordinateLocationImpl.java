package de.digitalcollections.model.impl.identifiable.entity.geo;

import de.digitalcollections.model.api.identifiable.entity.geo.CoordinateLocation;

public class CoordinateLocationImpl implements CoordinateLocation {

  private double altitude;
  private double latitude;
  private double longitude;
  private double precision;

  public CoordinateLocationImpl() {}

  public CoordinateLocationImpl(
      Double latitude, Double longitude, Double altitude, Double precision) {
    if (latitude != null) {
      this.latitude = latitude.doubleValue();
    }
    if (longitude != null) {
      this.longitude = longitude.doubleValue();
    }
    if (altitude != null) {
      this.altitude = altitude.doubleValue();
    }
    if (precision != null) {
      this.precision = precision.doubleValue();
    }
  }

  @Override
  public double getAltitude() {
    return altitude;
  }

  @Override
  public double getLatitude() {
    return latitude;
  }

  @Override
  public double getLongitude() {
    return longitude;
  }

  @Override
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
