package de.digitalcollections.model.impl.identifiable.parts;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;

public class LocalizedTextImpl extends HashMap<Locale, String> implements LocalizedText {

  public LocalizedTextImpl() {
    super();
  }

  public LocalizedTextImpl(Locale locale, String text) {
    this();
    this.put(locale, text);
  }

  @Override
  public Collection<Locale> getLocales() {
    return new LinkedHashSet<>(this.keySet());
  }

  @Override
  public String getText() {
    Collection<Locale> locales = getLocales();
    if (locales.isEmpty()) {
      return null;
    }
    return getText(locales.iterator().next());
  }

  @Override
  public String getText(Locale locale) {
    if (this.containsKey(locale)) {
      return this.get(locale);
    }
    return getText();
  }

  @Override
  public void setText(Locale locale, String text) {
    this.put(locale, text);
  }

}
