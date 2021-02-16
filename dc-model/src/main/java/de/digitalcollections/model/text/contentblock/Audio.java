package de.digitalcollections.model.text.contentblock;

/** An embedded audio. */
public class Audio extends ContentBlockWithAttributes {

  public Audio() {}

  public Audio(
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
