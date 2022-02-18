package de.digitalcollections.model.jackson.mixin.list.paging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.list.paging.SearchPageRequest;

@JsonDeserialize(as = SearchPageRequest.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SearchPageRequestMixIn extends PageRequestMixIn {}
