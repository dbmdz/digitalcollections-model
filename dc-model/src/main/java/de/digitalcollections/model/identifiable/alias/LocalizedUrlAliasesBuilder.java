package de.digitalcollections.model.identifiable.alias;

public class LocalizedUrlAliasesBuilder {

  LocalizedUrlAliases localizedUrlAliases = new LocalizedUrlAliases();

  public LocalizedUrlAliases build() {
    return localizedUrlAliases;
  }

  public LocalizedUrlAliasesBuilder addUrlAlias(UrlAlias urlAlias) {
    localizedUrlAliases.add(urlAlias);
    return this;
  }
}
