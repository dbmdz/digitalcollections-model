package de.digitalcollections.model.jackson.mixin.alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.alias.LocalizedUrlAliases;
import de.digitalcollections.model.alias.UrlAlias;
import java.util.List;
import java.util.Locale;

@JsonDeserialize(as = LocalizedUrlAliases.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LocalizedUrlAliasesMixIn {

  @JsonIgnore
  void add(UrlAlias... urlAlias);

  @JsonIgnore
  List<Locale> getTargetLanguages();

  @JsonIgnore
  boolean hasTargetLanguage(Locale locale);
}
