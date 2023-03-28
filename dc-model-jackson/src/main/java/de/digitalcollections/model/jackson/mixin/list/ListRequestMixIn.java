package de.digitalcollections.model.jackson.mixin.list;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.list.ListRequest;
import de.digitalcollections.model.list.paging.PageRequest;

@JsonDeserialize(as = ListRequest.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "listRequestType", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ListRequest.class, name = "LIST_REQUEST"),
  @JsonSubTypes.Type(value = PageRequest.class, name = "PAGE_REQUEST")
})
public abstract class ListRequestMixIn {}
