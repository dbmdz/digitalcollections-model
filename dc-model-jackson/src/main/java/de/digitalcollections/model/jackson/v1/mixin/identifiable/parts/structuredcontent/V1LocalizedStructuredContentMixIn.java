package de.digitalcollections.model.jackson.v1.mixin.identifiable.parts.structuredcontent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import java.util.Locale;
import java.util.Map;

@JsonDeserialize(as = LocalizedStructuredContentImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface V1LocalizedStructuredContentMixIn {

  @JsonProperty("documents")
  Map<Locale, StructuredContent> getLocalizedStructuredContent();

  @JsonIgnore
  void add(Locale locale, StructuredContent structuredContent);
}
