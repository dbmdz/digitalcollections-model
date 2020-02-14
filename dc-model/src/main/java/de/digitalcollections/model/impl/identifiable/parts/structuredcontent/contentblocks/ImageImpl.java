package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Image;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockWithAttributesImpl;

public class ImageImpl extends ContentBlockWithAttributesImpl implements Image {

  public ImageImpl() {}

  public ImageImpl(
      String alignment,
      String altText,
      String caption,
      boolean linkNewTab,
      String linkUrl,
      String resourceId,
      String title,
      String url,
      String width) {
    super();
    addAttribute("alignment", alignment);
    addAttribute("altText", altText);
    addAttribute("caption", caption);
    addAttribute("linkNewTab", linkNewTab);
    addAttribute("linkUrl", linkUrl);
    addAttribute("resourceId", resourceId);
    addAttribute("title", title);
    addAttribute("url", url);
    addAttribute("width", width);
  }
}
