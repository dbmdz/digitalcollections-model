package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.paging.Order;

@JsonDeserialize(as = Order.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class OrderMixIn {

  @JsonIgnore
  public abstract boolean isAscending();

  @JsonIgnore
  public abstract boolean isDescending();
}
