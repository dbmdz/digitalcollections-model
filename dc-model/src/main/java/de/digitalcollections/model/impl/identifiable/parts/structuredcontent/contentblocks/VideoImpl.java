package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Video;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockWithAttributesImpl;

public class VideoImpl extends ContentBlockWithAttributesImpl implements Video {

  public VideoImpl() {}

  public VideoImpl(
      String alignment,
      String caption,
      String previewUrl,
      String previewResourceId,
      String resourceId,
      String title,
      String url,
      String width) {
    super();
    addAttribute("alignment", alignment);
    addAttribute("caption", caption);
    addAttribute("previewUrl", previewUrl);
    addAttribute("previewResourceId", previewResourceId);
    addAttribute("resourceId", resourceId);
    addAttribute("title", title);
    addAttribute("url", url);
    addAttribute("width", width);
  }
}
