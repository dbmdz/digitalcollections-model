package de.digitalcollections.model.impl.identifiable.parts;

import de.digitalcollections.model.api.identifiable.parts.Translation;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;

public class LocalizedTextImpl implements LocalizedText {

  private Set<Translation> translations;

  public LocalizedTextImpl() {
    translations = new HashSet<>();
  }

  public LocalizedTextImpl(Locale locale, String text) {
    this();
    translations.add(new TranslationImpl(locale, text));
  }

  public LocalizedTextImpl(List<Locale> locales, String text) {
    this();
    for (Locale locale : locales) {
      translations.add(new TranslationImpl(locale, text));
    }
  }

  public LocalizedTextImpl(LocalizedText text) {
    this();
    for (Translation translation : text.getTranslations()) {
      translations.add(new TranslationImpl(translation.getLocale(), translation.getText()));
    }
  }

  private Translation findTranslation(Locale locale) {
    for (Translation translation : translations) {
      if (translation.has(locale)) {
        return translation;
      }
    }
    return null;
  }

  @Override
  public Collection<Locale> getLocales() {
    Set<Locale> locales = new HashSet<>();
    for (Translation translation : translations) {
      locales.add(translation.getLocale());
    }
    return locales;
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
    Translation translation = findTranslation(locale);
    if (translation != null) {
      return translation.getText();
    }
    return getText();
  }

  @Override
  public void setText(Locale locale, String text) {
    Translation translation = findTranslation(locale);
    if (translation != null) {
      translation.setText(text);
    } else {
      translations.add(new TranslationImpl(locale, text));
    }
  }

  @Override
  public Set<Translation> getTranslations() {
    return translations;
  }

  @Override
  public void setTranslations(Set<Translation> translations) {
    this.translations = translations;
  }

}
