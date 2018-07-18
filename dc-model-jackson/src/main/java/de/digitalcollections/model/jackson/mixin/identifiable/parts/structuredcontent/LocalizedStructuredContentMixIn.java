package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import java.util.Locale;

@JsonDeserialize(as = LocalizedStructuredContentImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LocalizedStructuredContentMixIn {

  @JsonIgnore
  void add(Locale locale, StructuredContent structuredContent);
}
