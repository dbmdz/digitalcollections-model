package de.digitalcollections.model.alias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class LocalizedUrlAliases extends HashMap<Locale, List<UrlAlias>> {

  public LocalizedUrlAliases() {
    super();
  }

  public LocalizedUrlAliases(UrlAlias... urlAliases) {
    this();
    this.add(urlAliases);
  }

  public void add(UrlAlias... urlAliases) {
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

  public List<Locale> getTargetLanguages() {
    return new ArrayList<>(this.keySet());
  }

  public boolean hasTargetLanguage(Locale locale) {
    return this.containsKey(locale);
  }
}
