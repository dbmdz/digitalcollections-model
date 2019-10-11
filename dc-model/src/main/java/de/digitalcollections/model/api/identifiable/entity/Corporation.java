package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.net.URL;

/**
 * Corporation is used to describe a (business) corporation (like a project partner or organization).
 */
public interface Corporation extends Entity {

  /** @return localized formatted text describing corporation */
  LocalizedStructuredContent getText();

  /** @param text set localized formatted text describing corporation*/
  void setText(LocalizedStructuredContent text);

  /** @return URL to homepage of corporation */
  URL getHomepageUrl();

  /** @param url set URL to homepage of corporation */
  void setHomepageUrl(URL url);
}
