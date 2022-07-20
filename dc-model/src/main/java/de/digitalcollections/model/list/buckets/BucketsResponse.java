package de.digitalcollections.model.list.buckets;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.list.ListResponse;
import java.util.List;

public class BucketsResponse<T extends UniqueObject>
    extends ListResponse<Bucket<T>, BucketsRequest<T>> {

  private BucketsRequest<T> bucketsRequest;

  public BucketsResponse() {
    super();
  }

  public BucketsResponse(BucketsRequest<T> bucketsRequest, List<Bucket<T>> content) {
    this(bucketsRequest, content, -1);
  }

  public BucketsResponse(BucketsRequest<T> bucketsRequest, List<Bucket<T>> content, long total) {
    super(content, null);
    this.bucketsRequest = bucketsRequest;
    this.total = total;
  }

  public BucketsRequest<T> getBucketsRequest() {
    return bucketsRequest;
  }

  public void setBucketsRequest(BucketsRequest<T> bucketsRequest) {
    this.bucketsRequest = bucketsRequest;
  }
}
