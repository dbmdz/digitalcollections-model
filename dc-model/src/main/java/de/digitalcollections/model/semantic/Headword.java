package de.digitalcollections.model.semantic;

import de.digitalcollections.model.UniqueObject;
import java.util.Locale;

/**
 * See https://en.wikipedia.org/wiki/Headword and
 * https://de.wikipedia.org/wiki/Stichwort_(Dokumentation)
 *
 * <p>"A headword, head word, (lemma), or sometimes catchword, is the word under which a set of
 * related dictionary or encyclopaedia entries appears. The headword is used to locate the entry,
 * and dictates its alphabetical position."
 *
 * <p>(for difference to "lemma" see
 * http://www.differencebetween.net/language/difference-between-headword-and-lemma/)
 *
 * <p>As it is often interchangeable, we decided for practial reasons to use this class "Headword"
 * also for a lemma.
 */
public class Headword extends UniqueObject {

  private String label;
  private Locale locale;

  public Headword() {}

  public Headword(String label, Locale locale) {
    this.label = label;
    this.locale = locale;
  }

  public String getLabel() {
    return label;
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }
}
