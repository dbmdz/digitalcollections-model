package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.EntityType;

/**
 * https://books.google.de/books?id=foGBCgAAQBAJ&amp;pg=PA151:
 *
 * <p>The classes corresponding to the entities person, family and corporate body are subclasses of
 * the Agent class, since these entities share attributes and relationships between them. For
 * instance, intellectual creations may be gathered into a class "Work" and its creators may be
 * gathered into classes like "Person", "Family" and "Corporate body".
 */
public class Agent extends Entity {

  @Override
  public String toString() {
    return "Agent{"
        + "created="
        + created
        + ", lastModified="
        + lastModified
        + ", uuid="
        + uuid
        + ", description="
        + description
        + ", identifiers="
        + identifiers
        + ", label="
        + label
        + ", localizedUrlAliases="
        + localizedUrlAliases
        + ", previewImage="
        + previewImage
        + ", previewImageRenderingHints="
        + previewImageRenderingHints
        + ", type="
        + type
        + ", customAttributes="
        + customAttributes
        + ", entityType="
        + entityType
        + ", navDate="
        + navDate
        + ", refId="
        + refId
        + '}';
  }

  public static Builder builder() {
    return new Builder<>();
  }

  public static class Builder<E extends Agent, B extends Agent.Builder>
      extends Entity.Builder<Agent, B> {

    @Override
    protected EntityType getEntityType() {
      return EntityType.AGENT;
    }
  }
}
