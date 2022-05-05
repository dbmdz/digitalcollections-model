package de.digitalcollections.model.production;

import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import java.time.LocalDate;

/** Details (who, when and where) about the creation of the digital object. */
public class CreationInfo {

  /** The geolocation, where the creation of the digital object took geolocation */
  private GeoLocation geoLocation;

  /** The date, when the digital object was created */
  private LocalDate date;

  /** The creator of the digital object */
  private Agent creator;

  /**
   * @return the geolocation, where the creation of the digital object took geolocation
   */
  public GeoLocation getGeoLocation() {
    return geoLocation;
  }

  /**
   * Set the geolocation, where the creation of the digital object took geolocation
   *
   * @param geoLocation the geolocation
   */
  public void setGeoLocation(GeoLocation geoLocation) {
    this.geoLocation = geoLocation;
  }

  /**
   * @return the date, when the creation of the digital object happened
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Set the date, when then creation of the digital object happened
   *
   * @param date the date
   */
  public void setDate(LocalDate date) {
    this.date = date;
  }

  /**
   * @return the creator of the digital object
   */
  public Agent getCreator() {
    return creator;
  }

  /**
   * Specify, who created the digital object
   *
   * @param creator the creator
   */
  public void setCreator(Agent creator) {
    this.creator = creator;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CreationInfo{"
        + "geoLocation="
        + geoLocation
        + ", date="
        + date
        + ", creator="
        + creator
        + '}';
  }

  public static class Builder {
    CreationInfo creationInfo = new CreationInfo();

    public Builder geoLocation(GeoLocation geoLocation) {
      creationInfo.setGeoLocation(geoLocation);
      return this;
    }

    public Builder creator(Agent creator) {
      creationInfo.setCreator(creator);
      return this;
    }

    public Builder date(String date) {
      creationInfo.setDate(LocalDate.parse(date));
      return this;
    }

    public CreationInfo build() {
      return creationInfo;
    }
  }
}
