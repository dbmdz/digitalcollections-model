package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.IFrame;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockWithAttributesImpl;

public class IFrameImpl extends ContentBlockWithAttributesImpl implements IFrame {

  public IFrameImpl() {
  }

  public IFrameImpl(String src, String width, String height) {
    super();
    addAttribute("src", src);
    addAttribute("width", width);
    addAttribute("height", height);
  }

}
