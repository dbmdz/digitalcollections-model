package de.digitalcollections.model.identifiable.entity.semantic;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.text.LocalizedText;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class Subject extends UniqueObject {

  private LinkedHashSet<Identifier> identifiers;
  private LocalizedText label;

  public Subject() {
    super();
  }

  public Subject(LocalizedText label, Set<Identifier> identifiers, Set<Entity> relatedEntities) {
    this();
    this.label = label;
    this.identifiers = new LinkedHashSet<>(identifiers);
  }

  public Set<Identifier> getIdentifiers() {
    return identifiers;
  }

  public LocalizedText getLabel() {
    return label;
  }

  @Override
  protected void init() {
    super.init();
  }

  public void setIdentifiers(Set<Identifier> identifiers) {
    this.identifiers = new LinkedHashSet<>(identifiers);
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Subject)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Subject subject = (Subject) o;
    return Objects.equals(identifiers, subject.identifiers) && Objects.equals(label, subject.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), identifiers, label);
  }

  public abstract static class SubjectBuilder<C extends Subject, B extends SubjectBuilder<C, B>>
      extends UniqueObjectBuilder<C, B> {

    public B identifier(Identifier identifier) {
      if (identifiers == null) {
        identifiers = new LinkedHashSet<>(1);
      }
      identifiers.add(identifier);
      return self();
    }

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }

  @Override
  public String toString() {
    return "Subject{" + "identifiers=" + identifiers + ", label=" + label + ", uuid=" + uuid + '}';
  }
}
