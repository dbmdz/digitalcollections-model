package de.digitalcollections.model.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/** LocalizedText is used for unformatted text content in multiple languages. */
public class LocalizedText extends HashMap<Locale, String> {

  public LocalizedText() {
    super();
  }

  public LocalizedText(Locale locale, String text) {
    this();
    this.put(locale, text);
  }

  /** @return all locales for which translated texts are available. */
  public List<Locale> getLocales() {
    return new ArrayList<>(this.keySet());
  }

  /** @return first found text */
  public String getText() {
    List<Locale> locales = getLocales();
    if (locales.isEmpty()) {
      return null;
    }
    return getText(locales.iterator().next());
  }

  /**
   * @param locale the desired locale.
   * @return text with the given locale
   */
  public String getText(Locale locale) {
    if (this.containsKey(locale)) {
      return this.get(locale);
    }
    return getText();
  }

  public boolean has(Locale locale) {
    return getLocales().contains(locale);
  }

  /**
   * sets (means: "add" or "replace") a text with a given locale
   *
   * @param locale the locale of <code>text</code>
   * @param text the text content
   */
  public void setText(Locale locale, String text) {
    this.put(locale, text);
  }
}
