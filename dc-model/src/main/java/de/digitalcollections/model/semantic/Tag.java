package de.digitalcollections.model.semantic;

import de.digitalcollections.model.UniqueObject;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

/** Unique String for tagging objects. */
@SuperBuilder(buildMethodName = "prebuild")
public class Tag extends UniqueObject {

  private String name;

  public Tag() {
    super();
  }

  public Tag(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Tag)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Tag tag = (Tag) o;
    return Objects.equals(name, tag.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Tag{"
        + "name='"
        + name
        + "'"
        + ", created="
        + created
        + ", lastModified="
        + lastModified
        + ", uuid="
        + uuid
        + '}';
  }

  public abstract static class TagBuilder<C extends Tag, B extends TagBuilder<C, B>>
      extends UniqueObjectBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
