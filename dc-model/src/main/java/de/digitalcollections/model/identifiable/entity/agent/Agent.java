package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.NamedEntity;
import de.digitalcollections.model.text.LocalizedText;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import lombok.experimental.SuperBuilder;

/**
 * https://books.google.de/books?id=foGBCgAAQBAJ&amp;pg=PA151:
 *
 * <p>The classes corresponding to the entities person, family and corporate body are subclasses of
 * the Agent class, since these entities share attributes and relationships between them. For
 * instance, intellectual creations may be gathered into a class "Work" and its creators may be
 * gathered into classes like "Person", "Family" and "Corporate body".
 */
@SuperBuilder(buildMethodName = "prebuild")
public class Agent extends Entity implements NamedEntity {

  private LocalizedText name;
  private Set<Locale> nameLocalesOfOriginalScript;

  public Agent() {
    super();
    init();
  }

  @Override
  protected void init() {
    super.init();
    if (nameLocalesOfOriginalScript == null) {
      nameLocalesOfOriginalScript = new HashSet<>(0);
    }
  }

  @Override
  public LocalizedText getName() {
    return name;
  }

  @Override
  public Set<Locale> getNameLocalesOfOriginalScript() {
    return nameLocalesOfOriginalScript;
  }

  @Override
  public void setName(LocalizedText name) {
    this.name = name;
  }

  public void setNameLocalesOfOriginalScript(Set<Locale> nameLocalesOfOriginalScript) {
    this.nameLocalesOfOriginalScript = nameLocalesOfOriginalScript;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Agent)) {
      return false;
    }
    Agent other = (Agent) obj;
    return obj == this
        || super.equals(obj)
            && Objects.equals(name, other.name)
            && Objects.equals(nameLocalesOfOriginalScript, other.nameLocalesOfOriginalScript);
  }

  @Override
  public int hashCode() {
    return super.hashCode() + Objects.hash(name, nameLocalesOfOriginalScript) + 93;
  }

  @Override
  public String toString() {
    return "Agent [name="
        + name
        + ", nameLocalesOfOriginalScript="
        + nameLocalesOfOriginalScript
        + ", customAttributes="
        + customAttributes
        + ", navDate="
        + navDate
        + ", refId="
        + refId
        + ", notes="
        + notes
        + ", description="
        + description
        + ", identifiableObjectType="
        + identifiableObjectType
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
        + ", tags="
        + tags
        + ", type="
        + type
        + ", created="
        + created
        + ", lastModified="
        + lastModified
        + ", uuid="
        + uuid
        + "]";
  }

  public abstract static class AgentBuilder<C extends Agent, B extends AgentBuilder<C, B>>
      extends EntityBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }

    public B addName(Locale locale, String name) {
      if (this.name == null) {
        this.name = new LocalizedText(locale, name);
      } else {
        this.name.put(locale, name);
      }
      return self();
    }

    public B addName(String name) {
      if (this.name == null) {
        this.name = new LocalizedText(Locale.ROOT, name);
      } else {
        this.name.put(Locale.ROOT, name);
      }
      return self();
    }
  }
}
