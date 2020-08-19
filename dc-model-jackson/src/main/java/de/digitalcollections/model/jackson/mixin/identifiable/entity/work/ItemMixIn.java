package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.impl.identifiable.entity.work.ItemImpl;

@JsonDeserialize(as = ItemImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ITEM")
public interface ItemMixIn {

  @JsonIgnore
  LocalizedText getTitle();
}
