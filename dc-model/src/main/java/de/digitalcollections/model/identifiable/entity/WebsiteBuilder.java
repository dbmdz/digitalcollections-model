package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.web.Webpage;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebsiteBuilder extends EntityBuilder<Website, WebsiteBuilder> {

  @Override
  protected IdentifiableType getIdentifiableType() {
    return IdentifiableType.ENTITY;
  }

  @Override
  protected EntityType getEntityType() {
    return EntityType.WEBSITE;
  }

  public WebsiteBuilder withUrl(String url) throws MalformedURLException {
    identifiable.setUrl(new URL(url));
    return this;
  }

  @Deprecated
  public WebsiteBuilder withDescription(LocalizedStructuredContent description) {
    identifiable.setDescription(description);
    return this;
  }

  public WebsiteBuilder withRootPages(List<Webpage> rootPages) {
    identifiable.setRootPages(rootPages);
    return this;
  }
}
