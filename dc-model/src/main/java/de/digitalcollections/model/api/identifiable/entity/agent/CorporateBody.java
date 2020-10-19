package de.digitalcollections.model.api.identifiable.entity.agent;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.net.URL;

/**
 * CorporateBody is used to describe a (business) corporation (e.g. a project partner or
 * organization or creator of a work). See
 * https://de.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records and
 * http://www.ib.hu-berlin.de/~kumlau/handreichungen/h189/#auf
 */
public interface CorporateBody extends Entity, Agent {

  /** @return localized formatted text describing corporate body */
  LocalizedStructuredContent getText();

  /** @param text set localized formatted text describing corporate body */
  void setText(LocalizedStructuredContent text);

  /** @return URL to homepage of corporate body */
  URL getHomepageUrl();

  /** @param url set URL to homepage of corporate body */
  void setHomepageUrl(URL url);
}
