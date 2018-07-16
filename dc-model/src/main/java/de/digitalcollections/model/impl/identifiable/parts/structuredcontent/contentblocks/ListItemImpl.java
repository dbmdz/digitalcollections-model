package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.ListItem;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockNodeImpl;

public class ListItemImpl extends ContentBlockNodeImpl implements ListItem {

  public ListItemImpl() {
  }

  public ListItemImpl(String text) {
    addContentBlock(new ParagraphImpl(text));
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{hashCode=" + hashCode() + "}";
  }
}
