package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.paging.impl.SortingImpl;

@JsonDeserialize(as = SortingImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SortingMixIn {

}
