package de.digitalcollections.model.impl.identifiable.parts.structuredcontent;

import java.util.Locale;
import java.util.Map;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;

public class LocalizedStructuredContentImpl implements LocalizedStructuredContent {

  private Map<Locale, StructuredContent> localizedStructuredContent;

  @Override
  public Map<Locale, StructuredContent> get() {
    return localizedStructuredContent;
  }

  @Override
  public void set(Map<Locale, StructuredContent> localizedStructuredContent) {
    this.localizedStructuredContent = localizedStructuredContent;
  }

}
