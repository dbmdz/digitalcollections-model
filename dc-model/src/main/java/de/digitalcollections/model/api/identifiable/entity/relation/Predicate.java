package de.digitalcollections.model.api.identifiable.entity.relation;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import java.time.LocalDateTime;

/** Specifies the type of a relation */
public interface Predicate {

  /**
   * Value of the predicate, shall be filled in snake_case and lowercase
   *
   * @return value, e.g. <code>is_author_of</code>
   */
  String getValue();

  /**
   * Sets the value of the predicate
   *
   * @param value the value, preferrably in snake_case and lowercase, e.g. <code>is_author_of</code>
   */
  void setValue(String value);

  /**
   * The multilingual label of the predicate
   *
   * @return multilingual label
   */
  LocalizedText getLabel();

  /**
   * Sets the multilingual label
   *
   * @param label the label as LocalizedText
   */
  void setLabel(LocalizedText label);

  /**
   * The multilingual, verbose description of the predicate
   *
   * @return the description
   */
  LocalizedText getDescription();

  /**
   * Sets the verbose and multilingual description of the predicate
   *
   * @param description the description
   */
  void setDescription(LocalizedText description);

  /**
   * Creation date of the predicate
   *
   * @return the creation date of the predicate
   */
  LocalDateTime getCreated();

  /**
   * Sets the creation time (should normally only be done by the persistence layer)
   *
   * @param created the creation date of the predicate
   */
  void setCreated(LocalDateTime created);

  /**
   * Last modification date of the predicate
   *
   * @return the last modification date of the predicate
   */
  LocalDateTime getLastModified();

  /**
   * Sets the last modification date of the predicate (should normally only be done by the
   * persistence layer)
   *
   * @param lastModified the last modification date of the predicate, e.g. "now" when any attribute
   *     changes
   */
  void setLastModified(LocalDateTime lastModified);
}
