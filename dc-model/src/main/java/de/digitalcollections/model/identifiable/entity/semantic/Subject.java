package de.digitalcollections.model.identifiable.entity.semantic;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Set;

public class Subject {

  private Set<Identifier> identifiers;
  private LocalizedText label;
  private Set<Entity> relatedEntities;

  public Subject() {}

  public Subject(LocalizedText label, Set<Identifier> identifiers, Set<Entity> relatedEntities) {
    this.label = label;
    this.identifiers = identifiers;
    this.relatedEntities = relatedEntities;
  }

  public Set<Identifier> getIdentifiers() {
    return identifiers;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public Set<Entity> getRelatedEntities() {
    return relatedEntities;
  }

  public void setIdentifiers(Set<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setRelatedEntities(Set<Entity> relatedEntities) {
    this.relatedEntities = relatedEntities;
  }
}
