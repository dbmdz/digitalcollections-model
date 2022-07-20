package de.digitalcollections.model.list.buckets;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.list.ListRequest;
import de.digitalcollections.model.list.filtering.Filtering;
import de.digitalcollections.model.list.sorting.Sorting;

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

  private int numberOfBuckets;
  private Bucket<T> parentBucket;

  /**
   * Creates a new {@link BucketsRequest} with sorting parameters applied.
   *
   * @param numberOfBuckets number (which is a literal positive integer number) of buckets the list
   *     should be divided into.
   * @param parentBucket bucket to be split into buckets or null if top bucket (whole list) ist to
   *     be split
   * @param sorting can be {@literal null}
   * @param filtering contains list of filter criterias
   */
  public BucketsRequest(
      int numberOfBuckets, Bucket<T> parentBucket, Sorting sorting, Filtering filtering) {
    super(sorting, filtering, null);
    if (numberOfBuckets < 1) {
      throw new IllegalArgumentException("numberOfBuckets must not be less than one!");
    }
    this.numberOfBuckets = numberOfBuckets;
    this.parentBucket = parentBucket;
  }

  public BucketsRequest(
      int bucketSize, T startObject, T endObject, Sorting sorting, Filtering filtering) {
    this(bucketSize, new Bucket<>(startObject, endObject), sorting, filtering);
  }

  public BucketsRequest(int bucketSize) {
    this(bucketSize, (Bucket<T>) null, (Sorting) null, (Filtering) null);
  }

  public BucketsRequest() {}

  public int getNumberOfBuckets() {
    return numberOfBuckets;
  }

  public Bucket<T> getParentBucket() {
    return parentBucket;
  }

  public void setNumberOfBuckets(int numberOfBuckets) {
    this.numberOfBuckets = numberOfBuckets;
  }

  public void setParentBucket(Bucket<T> parentBucket) {
    this.parentBucket = parentBucket;
  }
}
