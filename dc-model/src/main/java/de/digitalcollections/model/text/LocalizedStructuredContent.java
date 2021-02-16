package de.digitalcollections.model.text;

import java.util.HashMap;
import java.util.Locale;

/** LocalizedStructuredContent is used for formatted text content in multiple languages. */
public class LocalizedStructuredContent extends HashMap<Locale, StructuredContent> {

  public LocalizedStructuredContent() {
    super();
  }
}
