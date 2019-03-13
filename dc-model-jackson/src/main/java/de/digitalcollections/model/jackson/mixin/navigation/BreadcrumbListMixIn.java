package de.digitalcollections.model.jackson.mixin.navigation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.navigation.BreadcrumbListImpl;

@JsonDeserialize(as = BreadcrumbListImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"@context", "@type", "itemListElement"})
public interface BreadcrumbListMixIn {

  @JsonProperty("@type")
  String getType();

  @JsonProperty("@context")
  String getContext();

}
