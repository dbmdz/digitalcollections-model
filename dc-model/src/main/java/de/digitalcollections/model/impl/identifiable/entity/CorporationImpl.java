package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Corporation;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.net.URL;

public class CorporationImpl extends EntityImpl implements Corporation {

  private URL homepageUrl;

  private LocalizedStructuredContent text;

  public CorporationImpl() {
    super();
    this.entityType = EntityType.CORPORATION;
  }

  @Override
  public URL getHomepageUrl() {
    return homepageUrl;
  }

  @Override
  public void setHomepageUrl(URL homepageUrl) {
    this.homepageUrl = homepageUrl;
  }

  @Override
  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }
}
