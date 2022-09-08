package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import java.util.List;
import lombok.experimental.SuperBuilder;

/** Example: Mayence, Anvers, Bruxelles : chez les fils de B. Schott */
@SuperBuilder(buildMethodName = "prebuild")
public class Publication extends UniqueObject {

  private List<HumanSettlement> publicationLocations;
  private List<Agent> publishers;
  private List<String> publishersPresentation;

  public Publication() {
    super();
  }

  public Publication(
      List<HumanSettlement> publicationLocations,
      List<Agent> publishers,
      List<String> publishersPresentation) {
    this();
    this.publicationLocations = publicationLocations;
    this.publishers = publishers;
    this.publishersPresentation = publishersPresentation;
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

  @Override
  protected void init() {
    super.init();
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
        + ", uuid="
        + uuid
        + '}';
  }

  public abstract static class PublicationBuilder<
          C extends Publication, B extends PublicationBuilder<C, B>>
      extends UniqueObjectBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
