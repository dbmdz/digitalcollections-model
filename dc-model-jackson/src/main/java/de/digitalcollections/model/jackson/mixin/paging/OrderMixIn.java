package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.paging.impl.OrderImpl;

@JsonDeserialize(as = OrderImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class OrderMixIn {

}
