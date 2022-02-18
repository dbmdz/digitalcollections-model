package de.digitalcollections.model.list.buckets;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.list.ListResponse;
import java.util.List;

public class BucketObjectsResponse<T extends UniqueObject> extends ListResponse<T> {

  private BucketObjectsRequest<T> bucketObjectsRequest;

  public BucketObjectsResponse(BucketObjectsRequest<T> bucketObjectsRequest, List<T> content) {
    this(bucketObjectsRequest, content, -1);
  }

  public BucketObjectsResponse(
      BucketObjectsRequest<T> bucketObjectsRequest, List<T> content, long total) {
    super(content, null);
    this.bucketObjectsRequest = bucketObjectsRequest;
    this.total = total;
  }

  public BucketObjectsRequest<T> getBucketObjectsRequest() {
    return bucketObjectsRequest;
  }
}
