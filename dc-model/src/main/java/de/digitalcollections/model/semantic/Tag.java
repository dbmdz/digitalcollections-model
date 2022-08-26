package de.digitalcollections.model.semantic;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.text.LocalizedText;
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
