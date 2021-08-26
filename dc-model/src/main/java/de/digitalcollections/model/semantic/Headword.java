package de.digitalcollections.model.semantic;

import java.util.Locale;
import java.util.UUID;

/**
 * See https://en.wikipedia.org/wiki/Headword and
 * https://de.wikipedia.org/wiki/Stichwort_(Dokumentation)
 *
 * <p>"A headword, head word, (lemma), or sometimes catchword, is the word under which a set of
 * related dictionary or encyclopaedia entries appears. The headword is used to locate the entry,
 * and dictates its alphabetical position."</p>
 * 
 * <p>(for difference to "lemma" see http://www.differencebetween.net/language/difference-between-headword-and-lemma/)</p>
 */
public class Headword {

  private String label;
  private Locale locale;
  private UUID uuid;

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

  public UUID getUuid() {
    return uuid;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
