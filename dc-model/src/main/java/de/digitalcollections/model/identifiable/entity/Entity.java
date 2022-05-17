package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import java.time.LocalDate;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

/**
 * Entities are uniquely identifiable objects, often also uniquely identifiable outside of this
 * technical system - by additionally having unique identifiers of other systems (like GND-Id,
 * VIAF-ID, etc.). An entity is of a specific entity type, like e.g. cultural object, item,
 * manifestation, work, digital object, person, corporation.
 *
 * <p>Bibliographic entity types for example are defined in the “Functional Requirements for
 * Bibliographic Records” (FRBR; deutsch ‚Funktionale Anforderungen an bibliographische
 * Datensätze‘): see Wikipedia “Functional Requirements for Bibliographic Records”, URLs:
 *
 * <p>https://de.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records
 * https://en.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records
 */
@SuperBuilder(buildMethodName = "prebuild")
public class Entity extends Identifiable {

  protected CustomAttributes customAttributes;
  protected EntityType entityType;
  /** A "navigable" date, required when you need to the display the digital object on a timeline. */
  protected LocalDate navDate;

  protected long refId;

  public Entity() {
    super();
    init();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Entity)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Entity entity = (Entity) o;
    return refId == entity.refId
        && Objects.equals(customAttributes, entity.customAttributes)
        && entityType == entity.entityType;
  }

  /**
   * @param attributeName attribute name of custom attribute
   * @return value of custom attribute or null
   */
  public Object getCustomAttribute(String attributeName) {
    if (hasCustomAttribute(attributeName)) {
      return getCustomAttributes().get(attributeName);
    }
    return null;
  }

  /**
   * @return custom attributes
   */
  public CustomAttributes getCustomAttributes() {
    return customAttributes;
  }

  /**
   * @return the type of the entity (one of the types this system can manage, defined in enum
   *     EntityType).
   */
  public EntityType getEntityType() {
    return entityType;
  }

  /**
   * @return a date for "navigation" purposes, e.g. a timeline
   */
  public LocalDate getNavDate() {
    return navDate;
  }

  /**
   * Get the system wide unique reference id. Makes it possible to create very short permanent URIs
   * by using a number.
   *
   * @return system wide unique entity reference id
   */
  public long getRefId() {
    return refId;
  }

  /**
   * @param attributeName attribute name for lookup
   * @return true if map contains custom attribute of given name
   */
  private boolean hasCustomAttribute(String attributeName) {
    return customAttributes != null && customAttributes.containsKey(attributeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), customAttributes, entityType, refId);
  }

  @Override
  protected void init() {
    super.init();
    this.entityType = EntityType.ENTITY;
    this.type = IdentifiableType.ENTITY;
  }

  /**
   * Sets custom Attribute of given name to given value (overwriting existing value).
   *
   * @param attributeName name of custom attribute
   * @param attributeValue value of custom attibute
   */
  public void setCustomAttribute(String attributeName, Object attributeValue) {
    if (customAttributes == null) {
      customAttributes = new CustomAttributes();
    }
    customAttributes.put(attributeName, attributeValue);
  }

  /**
   * Set custom attributes (name, value).
   *
   * @param customAttributes custom attributes to be set
   */
  public void setCustomAttributes(CustomAttributes customAttributes) {
    this.customAttributes = customAttributes;
  }

  /**
   * @param entityType the type of the entity
   */
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }

  /**
   * Sets the "navigation" date
   *
   * @param navDate the "navigation" date
   */
  public void setNavDate(LocalDate navDate) {
    this.navDate = navDate;
  }

  /**
   * @param refId system wide unique entity reference id.
   */
  public void setRefId(long refId) {
    this.refId = refId;
  }

  public abstract static class EntityBuilder<C extends Entity, B extends EntityBuilder<C, B>>
      extends IdentifiableBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }

    public B customAttribute(String key, Object value) {
      if (this.customAttributes == null) {
        this.customAttributes = new CustomAttributes();
      }
      this.customAttributes.put(key, value);
      return self();
    }

    public B navDate(String navDate) {
      this.navDate = LocalDate.parse(navDate);
      return self();
    }
  }
}
