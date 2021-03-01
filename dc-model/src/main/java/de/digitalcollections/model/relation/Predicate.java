package de.digitalcollections.model.relation;

import de.digitalcollections.model.text.LocalizedText;
import java.time.LocalDateTime;

/** Specifies the type of a relation */
public class Predicate {

  private LocalDateTime created;
  private LocalizedText description;
  private LocalizedText label;
  private LocalDateTime lastModified;
  private String value;

  /**
   * Creation date of the predicate
   *
   * @return the creation date of the predicate
   */
  public LocalDateTime getCreated() {
    return created;
  }

  /**
   * The multilingual, verbose description of the predicate
   *
   * @return the description
   */
  public LocalizedText getDescription() {
    return description;
  }

  /**
   * The multilingual label of the predicate
   *
   * @return multilingual label
   */
  public LocalizedText getLabel() {
    return label;
  }

  /**
   * Last modification date of the predicate
   *
   * @return the last modification date of the predicate
   */
  public LocalDateTime getLastModified() {
    return lastModified;
  }

  /**
   * Value of the predicate, shall be filled in snake_case and lowercase
   *
   * @return value, e.g. <code>is_author_of</code>
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the creation time (should normally only be done by the persistence layer)
   *
   * @param created the creation date of the predicate
   */
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  /**
   * Sets the verbose and multilingual description of the predicate
   *
   * @param description the description
   */
  public void setDescription(LocalizedText description) {
    this.description = description;
  }

  /**
   * Sets the multilingual label
   *
   * @param label the label as LocalizedText
   */
  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  /**
   * Sets the last modification date of the predicate (should normally only be done by the
   * persistence layer)
   *
   * @param lastModified the last modification date of the predicate, e.g. "now" when any attribute
   *     changes
   */
  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  /**
   * Sets the value of the predicate
   *
   * @param value the value, preferrably in snake_case and lowercase, e.g. <code>is_author_of</code>
   */
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
        + "{value='"
        + value
        + "', label="
        + label
        + ", description="
        + description
        + ", created="
        + created
        + ", lastModified="
        + lastModified
        + "}";
  }
}
