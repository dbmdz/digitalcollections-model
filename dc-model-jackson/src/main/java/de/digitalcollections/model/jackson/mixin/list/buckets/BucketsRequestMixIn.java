package de.digitalcollections.model.jackson.mixin.list.buckets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.list.buckets.BucketsRequest;

@JsonDeserialize(as = BucketsRequest.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BucketsRequestMixIn {}
