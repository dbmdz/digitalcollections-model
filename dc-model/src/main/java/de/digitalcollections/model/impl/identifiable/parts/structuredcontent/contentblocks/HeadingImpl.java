package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Heading;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockNodeWithAttributesImpl;

public class HeadingImpl extends ContentBlockNodeWithAttributesImpl implements Heading {

  public HeadingImpl() {
  }

  public HeadingImpl(int level, String text) {
    addContentBlock(new TextImpl(text));
    addAttribute("level", level);
  }

}
