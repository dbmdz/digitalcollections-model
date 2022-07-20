package de.digitalcollections.model.jackson.mixin.list.buckets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.list.buckets.BucketObjectsRequest;

@JsonDeserialize(as = BucketObjectsRequest.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BucketObjectsRequestMixIn {

  @JsonIgnore
  public abstract int getOffset();
}
