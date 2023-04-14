package de.digitalcollections.model.jackson.mixin.list;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.list.ListRequest;

@JsonDeserialize(as = ListRequest.class)
public abstract class ListRequestMixIn {}
