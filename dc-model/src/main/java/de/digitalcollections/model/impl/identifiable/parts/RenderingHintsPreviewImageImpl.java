package de.digitalcollections.model.impl.identifiable.parts;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.RenderingHintsPreviewImage;
import java.net.URL;

public class RenderingHintsPreviewImageImpl implements RenderingHintsPreviewImage {

  private LocalizedText altText;
  private LocalizedText caption;
  private LocalizedText title;
  private URL targetLink;
  private boolean openLinkInNewWindow;

  @Override
  public LocalizedText getAltText() {
    return altText;
  }

  @Override
  public void setAltText(LocalizedText altText) {
    this.altText = altText;
  }

  @Override
  public LocalizedText getCaption() {
    return caption;
  }

  @Override
  public void setCaption(LocalizedText caption) {
    this.caption = caption;
  }

  @Override
  public LocalizedText getTitle() {
    return title;
  }

  @Override
  public void setTitle(LocalizedText title) {
    this.title = title;
  }

  @Override
  public URL getTargetLink() {
    return targetLink;
  }

  @Override
  public void setTargetLink(URL targetLink) {
    this.targetLink = targetLink;
  }

  @Override
  public void setOpenLinkInNewWindow(boolean openLinkInNewWindow) {
    this.openLinkInNewWindow = openLinkInNewWindow;
  }

  @Override
  public boolean isOpenLinkInNewWindow() {
    return openLinkInNewWindow;
  }
}
