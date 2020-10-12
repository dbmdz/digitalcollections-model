package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.parts.CustomAttributes;

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
public interface Entity extends Identifiable {

  /**
   * @return the type of the entity (one of the types this system can manage, defined in enum
   *     EntityType).
   */
  EntityType getEntityType();

  /** @param entityType the type of the entity */
  void setEntityType(EntityType entityType);

  /**
   * Get the system wide unique reference id. Makes it possible to create very short permanent URIs
   * by using a number.
   *
   * @return system wide unique entity reference id
   */
  long getRefId();

  /** @param refId system wide unique entity reference id. */
  void setRefId(long refId);

  /** @return custom attributes */
  CustomAttributes getCustomAttributes();

  /**
   * @param attributeName attribute name of custom attribute
   * @return value of custom attribute or null
   */
  default Object getCustomAttribute(String attributeName) {
    if (hasCustomAttribute(attributeName)) {
      return getCustomAttributes().get(attributeName);
    }
    return null;
  }

  /**
   * @param attributeName attribute name for lookup
   * @return true if map contains custom attribute of given name
   */
  default boolean hasCustomAttribute(String attributeName) {
    CustomAttributes customAttributes = getCustomAttributes();
    return customAttributes != null && customAttributes.containsKey(attributeName);
  }

  /**
   * Sets custom Attribute of given name to given value (overwriting existing value).
   *
   * @param attributeName name of custom attribute
   * @param attributeValue value of custom attibute
   */
  void setCustomAttribute(String attributeName, Object attributeValue);

  /**
   * Set custom attributes (name, value).
   *
   * @param customAttributes custom attributes to be set
   */
  void setCustomAttributes(CustomAttributes customAttributes);
}
