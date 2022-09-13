package de.digitalcollections.model.semantic;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

/**
 * To discuss: instead namespace, id Identifier? and then extend Identifiable? and then move to
 * ...identifiable.semantic?
 */
@SuperBuilder(buildMethodName = "prebuild")
public class Tag extends UniqueObject {

  private String id;
  private LocalizedText label;
  private String namespace;
  private String tagType;

  public Tag() {
    super();
  }

  public Tag(LocalizedText label, String tagType, String namespace, String id) {
    this.id = id;
    this.label = label;
    this.namespace = namespace;
    this.tagType = tagType;
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
    return Objects.equals(id, tag.id)
        && Objects.equals(label, tag.label)
        && Objects.equals(namespace, tag.namespace)
        && Objects.equals(tagType, tag.tagType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, label, namespace, tagType);
  }

  public String getId() {
    return id;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getTagType() {
    return tagType;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public void setTagType(String tagType) {
    this.tagType = tagType;
  }

  @Override
  public String toString() {
    return "Tag{"
        + "id='"
        + id
        + '\''
        + ", label="
        + label
        + ", namespace='"
        + namespace
        + '\''
        + ", tagType='"
        + tagType
        + '\''
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
