package de.digitalcollections.model.identifiable.entity.semantic;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Set;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class Subject extends UniqueObject {

  private Set<Identifier> identifiers;
  private LocalizedText label;

  public Subject() {
    super();
  }

  public Subject(LocalizedText label, Set<Identifier> identifiers) {
    this();
    this.label = label;
    this.identifiers = identifiers;
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
    this.identifiers = identifiers;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public abstract static class SubjectBuilder<C extends Subject, B extends SubjectBuilder<C, B>>
      extends UniqueObjectBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
