package de.digitalcollections.model.impl.identifiable.entity.agent;

import de.digitalcollections.model.api.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.net.URL;

public class CorporateBodyImpl extends AgentImpl implements CorporateBody {

  private URL homepageUrl;

  private LocalizedStructuredContent text;

  public CorporateBodyImpl() {
    super();
    this.entityType = EntityType.CORPORATE_BODY;
  }

  @Override
  public URL getHomepageUrl() {
    return homepageUrl;
  }

  @Override
  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public void setHomepageUrl(URL homepageUrl) {
    this.homepageUrl = homepageUrl;
  }

  @Override
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }
}
