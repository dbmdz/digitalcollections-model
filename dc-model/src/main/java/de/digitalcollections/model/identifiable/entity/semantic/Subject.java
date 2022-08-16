package de.digitalcollections.model.identifiable.entity.semantic;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Set;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class Subject {

  private Set<Identifier> identifiers;
  private LocalizedText label;
  private Set<Entity> relatedEntities;

  public Subject() {
    init();
  }

  public Subject(LocalizedText label, Set<Identifier> identifiers, Set<Entity> relatedEntities) {
    this();
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

  protected void init() {}

  public void setIdentifiers(Set<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setRelatedEntities(Set<Entity> relatedEntities) {
    this.relatedEntities = relatedEntities;
  }

  public abstract static class SubjectBuilder<C extends Subject, B extends SubjectBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
