package de.digitalcollections.model.list.buckets;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.list.Filtering;
import de.digitalcollections.model.list.ListRequest;
import de.digitalcollections.model.list.Sorting;

public class BucketObjectsRequest<T extends UniqueObject> extends ListRequest {

  private static final long serialVersionUID = 1L;

  private Bucket<T> bucket;

  public BucketObjectsRequest(Bucket<T> bucket, Sorting sorting, Filtering filtering) {
    super(sorting, filtering);
    this.bucket = bucket;
  }

  public Bucket<T> getBucket() {
    return bucket;
  }
}
