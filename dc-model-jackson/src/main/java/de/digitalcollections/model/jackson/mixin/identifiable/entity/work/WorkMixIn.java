package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.impl.identifiable.entity.work.WorkImpl;

@JsonDeserialize(as = WorkImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("WORK")
public interface WorkMixIn {

  @JsonIgnore
  LocalizedText getTitle();
}
