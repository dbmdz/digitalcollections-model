package de.digitalcollections.model.jackson.mixin.identifiable.parts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import java.util.Collection;
import java.util.Locale;

@JsonDeserialize(as = LocalizedTextImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LocalizedTextMixIn {

  @JsonIgnore
  Collection<String> getLanguages();

  @JsonIgnore
  Collection<Locale> getLocales();

  @JsonIgnore
  String getText();
}
