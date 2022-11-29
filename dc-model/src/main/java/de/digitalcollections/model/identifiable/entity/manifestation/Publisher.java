package de.digitalcollections.model.identifiable.entity.manifestation;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.time.LocalDateRange;
import de.digitalcollections.model.time.TimeValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

/** Example: Mayence, Anvers, Bruxelles : chez les fils de B. Schott */
@SuperBuilder(buildMethodName = "prebuild")
public class Publisher extends UniqueObject {

  private List<HumanSettlement> locations;
  private Agent agent;

  private LocalDateRange dateRange;
  private TimeValueRange timeValueRange;
  private String datePresentation;
  private String publisherPresentation;

  public Publisher() {
    super();
  }

  public Publisher(
      List<HumanSettlement> locations,
      Agent agent,
      String publisherPresentation,
      LocalDateRange dateRange,
      TimeValueRange timeValueRange,
      String datePresentation) {
    this();
    this.locations = locations;
    this.agent = agent;
    this.publisherPresentation = publisherPresentation;
    this.dateRange = dateRange;
    this.timeValueRange = timeValueRange;
    this.datePresentation = datePresentation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Publisher)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Publisher publisher = (Publisher) o;
    return Objects.equals(locations, publisher.locations)
        && Objects.equals(agent, publisher.agent)
        && Objects.equals(dateRange, publisher.dateRange)
        && Objects.equals(timeValueRange, publisher.timeValueRange)
        && Objects.equals(datePresentation, publisher.datePresentation)
        && Objects.equals(publisherPresentation, publisher.publisherPresentation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        locations,
        agent,
        dateRange,
        timeValueRange,
        datePresentation,
        publisherPresentation);
  }

  public List<HumanSettlement> getLocations() {
    return locations;
  }

  public Agent getAgent() {
    return agent;
  }

  public String getPublisherPresentation() {
    return publisherPresentation;
  }

  public void setLocations(List<HumanSettlement> locations) {
    this.locations = locations;
  }

  public void addLocation(HumanSettlement location) {
    if (locations == null) {
      locations = new ArrayList<>(1);
    }
    locations.add(location);
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  public void setPublisherPresentation(String publisherPresentation) {
    this.publisherPresentation = publisherPresentation;
  }

  public LocalDateRange getDateRange() {
    return dateRange;
  }

  public void setDateRange(LocalDateRange dateRange) {
    this.dateRange = dateRange;
  }

  public TimeValueRange getTimeValueRange() {
    return timeValueRange;
  }

  public void setTimeValueRange(TimeValueRange timeValueRange) {
    this.timeValueRange = timeValueRange;
  }

  public String getDatePresentation() {
    return datePresentation;
  }

  public void setDatePresentation(String datePresentation) {
    this.datePresentation = datePresentation;
  }

  @Override
  public String toString() {
    return "Publisher{"
        + "locations="
        + locations
        + ", agent="
        + agent
        + ", dateRange="
        + dateRange
        + ", timeValueRange="
        + timeValueRange
        + ", datePresentation='"
        + datePresentation
        + '\''
        + ", publisherPresentation='"
        + publisherPresentation
        + '\''
        + ", uuid="
        + uuid
        + '}';
  }

  public abstract static class PublisherBuilder<
          C extends Publisher, B extends PublisherBuilder<C, B>>
      extends UniqueObjectBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }

    public B location(HumanSettlement location) {
      if (locations == null) {
        locations = new ArrayList<>(1);
      }
      locations.add(location);
      return self();
    }
  }
}
