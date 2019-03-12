package de.digitalcollections.model.jackson.mixin.navigation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.navigation.ListItemImpl;

@JsonDeserialize(as = ListItemImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"@type", "position", "name", "item"})
public interface ListItemMixIn {

  @JsonProperty("@type")
  String getType();

}
