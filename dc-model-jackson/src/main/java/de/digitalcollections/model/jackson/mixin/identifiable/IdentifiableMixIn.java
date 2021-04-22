package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.text.LocalizedText;

@JsonDeserialize(as = Identifiable.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("identifiable")
public interface IdentifiableMixIn {

  @JsonSetter
  public void setLabel(LocalizedText label);
}
