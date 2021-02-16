package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.paging.PageRequest;

@JsonDeserialize(as = PageRequest.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PageRequestMixIn {

  @JsonIgnore
  public abstract int getOffset();
}
