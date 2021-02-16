package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import java.net.URL;

/**
 * CorporateBody is used to describe a (business) corporation (e.g. a project partner or
 * organization or creator of a work). See
 * https://de.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records and
 * http://www.ib.hu-berlin.de/~kumlau/handreichungen/h189/#auf
 */
public class CorporateBody extends Agent {

  private URL homepageUrl;

  private LocalizedStructuredContent text;

  public CorporateBody() {
    super();
    this.entityType = EntityType.CORPORATE_BODY;
  }

  /** @return URL to homepage of corporate body */
  public URL getHomepageUrl() {
    return homepageUrl;
  }

  /** @return localized formatted text describing corporate body */
  public LocalizedStructuredContent getText() {
    return text;
  }

  /** @param homepageUrl set URL to homepage of corporate body */
  public void setHomepageUrl(URL homepageUrl) {
    this.homepageUrl = homepageUrl;
  }

  /** @param text set localized formatted text describing corporate body */
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }
}
