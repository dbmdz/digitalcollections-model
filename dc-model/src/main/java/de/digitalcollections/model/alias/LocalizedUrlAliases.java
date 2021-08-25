package de.digitalcollections.model.alias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class LocalizedUrlAliases extends HashMap<Locale, List<UrlAlias>> {

  /**
   * Constructor, can be called without parameters as well, i.e. {@code new LocalizedUrlAliases()}
   *
   * @param urlAliases Not {@code null}
   */
  public LocalizedUrlAliases(UrlAlias... urlAliases) {
    super();
    this.add(urlAliases);
  }

  public LocalizedUrlAliases(List<UrlAlias> urlAliases) {
    this(urlAliases.toArray(UrlAlias[]::new));
  }

  public void add(UrlAlias... urlAliases) {
    if (urlAliases == null) {
      return;
    }
    for (UrlAlias urlAlias : urlAliases) {
      this.compute(
          urlAlias.getTargetLanguage(),
          (locale, listOfAliases) -> {
            if (listOfAliases == null) {
              listOfAliases = new ArrayList<>();
            }
            listOfAliases.add(urlAlias);
            return listOfAliases;
          });
    }
  }

  /** Check whether the passed {@code UrlAlias} is contained in any of the locale specific lists. */
  public boolean containsUrlAlias(UrlAlias urlAlias) {
    return this.flatten().contains(urlAlias);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o == null || !(o instanceof LocalizedUrlAliases)) {
      return false;
    }
    LocalizedUrlAliases other = (LocalizedUrlAliases) o;
    return super.equals(other);
  }

  /**
   * Flatten this map to a list.
   *
   * @return list containing all {@code UrlAlias}es from this object
   */
  public List<UrlAlias> flatten() {
    return this.values().stream().flatMap(list -> list.stream()).collect(Collectors.toList());
  }

  public List<Locale> getTargetLanguages() {
    return new ArrayList<>(this.keySet());
  }

  public boolean hasTargetLanguage(Locale locale) {
    return this.containsKey(locale);
  }
}
