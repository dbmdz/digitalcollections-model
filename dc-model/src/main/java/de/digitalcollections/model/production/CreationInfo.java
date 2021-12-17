package de.digitalcollections.model.production;

import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import java.time.LocalDate;

/** Details (who, when and where) about the creation of the digital object. */
public class CreationInfo {

  /** The place, where the creation of the digital object took place */
  private GeoLocation place;

  /** The date, when the digital object was created */
  private LocalDate date;

  /** The creator of the digital object */
  private Agent creator;

  /** @return the place, where the creation of the digital object took place */
  public GeoLocation getPlace() {
    return place;
  }

  /**
   * Set the place, where the creation of the digital object took place
   *
   * @param place the place
   */
  public void setPlace(GeoLocation place) {
    this.place = place;
  }

  /** @return the date, when the creation of the digital object happened */
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

  /** @return the creator of the digital object */
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

  @Override
  public String toString() {
    return "CreationInfo{" + "place=" + place + ", date=" + date + ", creator=" + creator + '}';
  }
}
