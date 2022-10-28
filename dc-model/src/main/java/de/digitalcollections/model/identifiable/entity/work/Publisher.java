package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

/** Example: Mayence, Anvers, Bruxelles : chez les fils de B. Schott */
@SuperBuilder(buildMethodName = "prebuild")
public class Publisher extends UniqueObject {

  private List<HumanSettlement> locations;
  private Agent agent;
  private String publisherPresentation;

  public Publisher() {
    super();
  }

  public Publisher(List<HumanSettlement> locations, Agent agent, String publisherPresentation) {
    this();
    this.locations = locations;
    this.agent = agent;
    this.publisherPresentation = publisherPresentation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Publisher)) {
      return false;
    }
    Publisher that = (Publisher) o;
    return Objects.equals(locations, that.locations)
        && Objects.equals(agent, that.agent)
        && Objects.equals(publisherPresentation, that.publisherPresentation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locations, agent, publisherPresentation);
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

  @Override
  public String toString() {
    return "Publication{"
        + "locations="
        + locations
        + ", agent="
        + agent
        + ", publisherPresentation="
        + publisherPresentation
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
