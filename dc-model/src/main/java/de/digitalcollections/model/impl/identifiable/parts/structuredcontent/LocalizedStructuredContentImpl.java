package de.digitalcollections.model.impl.identifiable.parts.structuredcontent;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import java.util.Locale;
import java.util.Map;

public class LocalizedStructuredContentImpl implements LocalizedStructuredContent {

  private Map<Locale, StructuredContent> localizedStructuredContent;

  public LocalizedStructuredContentImpl() {
  }

  @Override
  public Map<Locale, StructuredContent> getLocalizedStructuredContent() {
    return localizedStructuredContent;
  }

  @Override
  public void setLocalizedStructuredContent(Map<Locale, StructuredContent> localizedStructuredContent) {
    this.localizedStructuredContent = localizedStructuredContent;
  }

}
