package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.paging.impl.PageRequestImpl;

@JsonDeserialize(as = PageRequestImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PageRequestMixIn {
//public abstract class PageRequestMixIn extends PageRequestImpl {

  // TODO does not work, never called. workaround: had to introduce default constructor in PageRequestImpl
//  @JsonCreator
//  public PageRequestMixIn(
//          @JsonProperty("pageSize") int pageSize,
//          @JsonProperty("pageNumber") int pageNumber,
//          @JsonProperty("sorting") Sorting sorting) {
//    super(pageSize, pageNumber, sorting);
//  }
  @JsonIgnore
  //  @Override
  public abstract int getOffset();
}
