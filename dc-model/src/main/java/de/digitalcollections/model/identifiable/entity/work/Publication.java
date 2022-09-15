package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import java.util.List;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

/** Example: Mayence, Anvers, Bruxelles : chez les fils de B. Schott */
@SuperBuilder(buildMethodName = "prebuild")
public class Publication {

  private List<HumanSettlement> publicationLocations;
  private List<Agent> publishers;
  private List<String> publishersPresentation;

  public Publication() {}

  public Publication(
      List<HumanSettlement> publicationLocations,
      List<Agent> publishers,
      List<String> publishersPresentation) {
    this();
    this.publicationLocations = publicationLocations;
    this.publishers = publishers;
    this.publishersPresentation = publishersPresentation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Publication)) {
      return false;
    }
    Publication that = (Publication) o;
    return Objects.equals(publicationLocations, that.publicationLocations)
        && Objects.equals(publishers, that.publishers)
        && Objects.equals(publishersPresentation, that.publishersPresentation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publicationLocations, publishers, publishersPresentation);
  }

  public List<HumanSettlement> getPublicationLocations() {
    return publicationLocations;
  }

  public List<Agent> getPublishers() {
    return publishers;
  }

  public List<String> getPublishersPresentation() {
    return publishersPresentation;
  }

  public void setPublicationLocations(List<HumanSettlement> publicationLocations) {
    this.publicationLocations = publicationLocations;
  }

  public void setPublishers(List<Agent> publishers) {
    this.publishers = publishers;
  }

  public void setPublishersPresentation(List<String> publishersPresentation) {
    this.publishersPresentation = publishersPresentation;
  }

  @Override
  public String toString() {
    return "Publication{"
        + "publicationLocations="
        + publicationLocations
        + ", publishers="
        + publishers
        + ", publishersPresentation="
        + publishersPresentation
        + '}';
  }

  public abstract static class PublicationBuilder<
      C extends Publication, B extends PublicationBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      return c;
    }
  }
}
