package de.digitalcollections.model.impl.identifiable.parts.structuredcontent;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import java.util.Locale;
import java.util.Map;

public class LocalizedStructuredContentImpl implements LocalizedStructuredContent {

  private Map<Locale, StructuredContent> localizedStructuredContent;

  public LocalizedStructuredContentImpl() {
  }

  // FIXME: use service to get empty document or move logic to javascript
  @Deprecated
  public LocalizedStructuredContentImpl(Locale locale) {
    this();
    StructuredContent document = new StructuredContentImpl();
    document.addContentBlock(new ParagraphImpl());
    add(locale, document);
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
