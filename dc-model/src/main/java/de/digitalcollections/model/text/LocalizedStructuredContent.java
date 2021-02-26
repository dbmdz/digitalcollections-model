package de.digitalcollections.model.text;

import de.digitalcollections.model.view.ToCEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/** LocalizedStructuredContent is used for formatted text content in multiple languages. */
public class LocalizedStructuredContent extends HashMap<Locale, StructuredContent> {

  public LocalizedStructuredContent() {
    super();
  }

  public List<ToCEntry> getTableOfContent(Locale locale) {
    if (locale == null) {
      return null;
    }
    Map<Locale, List<ToCEntry>> tablesOfContents = getTablesOfContents();
    if (tablesOfContents != null) {
      return tablesOfContents.get(locale);
    }
    return null;
  }

  public Map<Locale, List<ToCEntry>> getTablesOfContents() {
    if (isEmpty()) {
      return null;
    }
    Map<Locale, List<ToCEntry>> tocs = new HashMap<>();
    for (Entry<Locale, StructuredContent> entry : entrySet()) {
      Locale key = entry.getKey();
      List<ToCEntry> value = entry.getValue().getTableOfContents();
      if (value != null) {
        tocs.put(key, value);
      }
    }
    return tocs;
  }
}
