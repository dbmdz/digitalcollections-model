package de.digitalcollections.model.api.identifiable.parts.structuredcontent;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * LocalizedStructuredContent is used for text content.
 */
public interface LocalizedStructuredContent {

  /**
   * @return (multilingual) text content
   */
  Map<Locale, StructuredContent> getLocalizedStructuredContent();

  /**
   * @param localizedStructuredContent the (multilingual) text content
   */
  void setLocalizedStructuredContent(Map<Locale, StructuredContent> localizedStructuredContent);

  default void add(Locale locale, StructuredContent structuredContent) {
    if (getLocalizedStructuredContent() == null) {
      setLocalizedStructuredContent(new HashMap<>());
    }
    getLocalizedStructuredContent().put(locale, structuredContent);
  }
}
