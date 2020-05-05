package de.digitalcollections.model.api.identifiable.parts;

import java.net.URL;

/**
 * Contains hints for rendering a preview image, e.g. in a webpage as HTML.<br>
 * These are related to an {@link
 * de.digitalcollections.model.api.identifiable.resource.ImageFileResource} but there may exist more
 * than one rendering hints container, each per individual use case.<br>
 * This makes it possible to use/embed an image in several projects and locations, each time
 * rendered individually.<br>
 * The rendering hints therefore are kept separate in an own rendering hints object and have to be
 * stored in conjunction with each specific use case.
 *
 * <p>Example:<br>
 * A person object has a portrait photo as preview image. On the detail page of this person (= use
 * case) specific caption and link are defined.<br>
 * So at the person storage an {@link
 * de.digitalcollections.model.api.identifiable.resource.ImageFileResource} is defined as preview
 * image and individual filled rendering hints are stored beside at the person object (and not
 * "centrally" at the reusable {@link
 * de.digitalcollections.model.api.identifiable.resource.ImageFileResource}).
 *
 * <p>This makes it possible to reuse an image in different use cases but with individual alt-text,
 * caption, (mouseover) title and link.
 */
public interface RenderingHintsPreviewImage {

  /**
   * @return localized text that is shown as alternative if image can not be shown and for
   *     accessibility (e.g. screen-reader)
   */
  LocalizedText getAltText();

  /**
   * @param altText localized text that is shown as alternative if image can not be shown and for
   *     accessibility (e.g. screen-reader)
   */
  void setAltText(LocalizedText altText);

  /** @return localized text that may be shown e.g. as "subtitle" under an image */
  LocalizedText getCaption();

  /** @param caption localized text that may be shown e.g. as "subtitle" under an image */
  void setCaption(LocalizedText caption);

  /**
   * @return localized text that may be shown e.g. as "mouseover" if image is rendered in an HTML
   *     page
   */
  LocalizedText getTitle();

  /**
   * @param title localized text that may be shown e.g. as "mouseover" if image is rendered in an
   *     HTML page
   */
  void setTitle(LocalizedText title);

  /**
   * @return url that is linked with the image and/or caption, e.g. used for click on image/caption
   *     as target location
   */
  URL getTargetLink();

  /**
   * @param targetLink url that is linked with the image and/or caption, e.g. used for click on
   *     image/caption as target location
   */
  void setTargetLink(URL targetLink);

  /** @return if targetLink should be opened in new window */
  boolean isOpenLinkInNewWindow();

  /** @param openLinkInNewWindow "true" if targetLink should be opened in new window */
  void setOpenLinkInNewWindow(boolean openLinkInNewWindow);
}
