package de.digitalcollections.model.impl.relations;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.relations.Predicate;
import java.time.LocalDateTime;

public class PredicateImpl implements Predicate {

  private String value;
  private LocalizedText label;
  private LocalizedText description;
  private LocalDateTime created;
  private LocalDateTime lastModified;

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public LocalizedText getLabel() {
    return label;
  }

  @Override
  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  @Override
  public LocalizedText getDescription() {
    return description;
  }

  @Override
  public void setDescription(LocalizedText description) {
    this.description = description;
  }

  @Override
  public LocalDateTime getCreated() {
    return created;
  }

  @Override
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  @Override
  public LocalDateTime getLastModified() {
    return lastModified;
  }

  @Override
  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  @Override
  public String toString() {
    return "PredicateImpl{"
        + "value='"
        + value
        + '\''
        + ", label="
        + label
        + ", description="
        + description
        + ", created="
        + created
        + ", lastModified="
        + lastModified
        + '}';
  }
}
