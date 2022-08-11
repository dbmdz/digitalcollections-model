package de.digitalcollections.model.semantic;

import de.digitalcollections.model.text.LocalizedText;

/**
 * To discuss: instead namespace, id Identifier? and then extend Identifiable? and then move to
 * ...identifiable.semantic?
 */
public class Tag {

  private String id;
  private LocalizedText label;
  private String namespace;
  private TagType tagType;

  public Tag() {}

  public Tag(LocalizedText label, TagType tagType, String namespace, String id) {
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

  public TagType getTagType() {
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

  public void setTagType(TagType tagType) {
    this.tagType = tagType;
  }
}
