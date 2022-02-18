package de.digitalcollections.model.list.buckets;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.list.Filtering;
import de.digitalcollections.model.list.ListRequest;
import de.digitalcollections.model.list.Sorting;

/**
 * A BucketsRequest allows you to break a list / result set into a specified number of approximately
 * equal groups, or buckets.<br>
 * It assigns each group a bucket number starting from one.<br>
 * For each row in a group, the bucket number represents the group to which the row belongs.
 *
 * @param <T> type of an UniqueObject contained in a Bucket
 */
public class BucketsRequest<T extends UniqueObject> extends ListRequest {

  private static final long serialVersionUID = 1L;

  private int bucketSize;
  private Bucket<T> parentBucket;

  /**
   * Creates a new {@link BucketsRequest} with sorting parameters applied.
   *
   * @param bucketSize number (which is a literal positive integer number) of buckets the list
   *     should be divided into.
   * @param parentBucket bucket to be split into buckets or null if top bucket (whole list) ist to
   *     be split
   * @param sorting can be {@literal null}
   * @param filtering contains list of filter criterias
   */
  public BucketsRequest(
      int bucketSize, Bucket<T> parentBucket, Sorting sorting, Filtering filtering) {
    super(sorting, filtering);
    if (bucketSize < 1) {
      throw new IllegalArgumentException("bucketSize index must not be less than one!");
    }
    this.bucketSize = bucketSize;
    this.parentBucket = parentBucket;
  }

  public BucketsRequest(
      int bucketSize, T startObject, T endObject, Sorting sorting, Filtering filtering) {
    this(bucketSize, new Bucket<>(startObject, endObject), sorting, filtering);
  }

  public int getBucketSize() {
    return bucketSize;
  }

  public Bucket<T> getParentBucket() {
    return parentBucket;
  }
}
