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
  Map<Locale, StructuredContent> get();

  /**
   * @param localizedStructuredContent the (multilingual) text content
   */
  void set(Map<Locale, StructuredContent> localizedStructuredContent);

  default void addDocument(Locale locale, StructuredContent structuredContent) {
    if (get() == null) {
      set(new HashMap<>());
    }
    get().put(locale, structuredContent);
  }
}
