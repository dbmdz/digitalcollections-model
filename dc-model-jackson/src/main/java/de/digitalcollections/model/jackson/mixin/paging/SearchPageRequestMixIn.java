package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.paging.SearchPageRequestImpl;

@JsonDeserialize(as = SearchPageRequestImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SearchPageRequestMixIn extends PageRequestMixIn {}
