package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockNodeImpl;

public class ParagraphImpl extends ContentBlockNodeImpl implements Paragraph {

  public ParagraphImpl() {}

  public ParagraphImpl(String text) {
    addContentBlock(new TextImpl(text));
  }
}
