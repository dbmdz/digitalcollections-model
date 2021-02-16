package de.digitalcollections.model.jackson.mixin.text;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import java.util.Locale;

@JsonDeserialize(as = LocalizedStructuredContent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LocalizedStructuredContentMixIn {

  @JsonIgnore
  void add(Locale locale, StructuredContent structuredContent);
}
