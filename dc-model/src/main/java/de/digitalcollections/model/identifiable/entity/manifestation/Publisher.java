package de.digitalcollections.model.identifiable.entity.manifestation;

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

  private List<HumanSettlement>
      locations; // nur Name (Anzeigeform) wird verwendet, keine Wiederverwendung
  private Agent agent; // nur Name (Anzeigeform) wird verwendet, keine Wiederverwendung

  private String datePresentation;

  public Publisher() {
    super();
  }

  public Publisher(
      List<HumanSettlement> locations,
      Agent agent,
      String publisherPresentation,
      String datePresentation) {
    this();
    this.locations = locations;
    this.agent = agent;
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
        && Objects.equals(datePresentation, publisher.datePresentation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), locations, agent, datePresentation);
  }

  public List<HumanSettlement> getLocations() {
    return locations;
  }

  public Agent getAgent() {
    return agent;
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
        + ", datePresentation='"
        + datePresentation
        + '\''
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
