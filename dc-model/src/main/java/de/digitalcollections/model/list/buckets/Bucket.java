package de.digitalcollections.model.list.buckets;

import de.digitalcollections.model.UniqueObject;

public class Bucket<T extends UniqueObject> {

  private final T endObject;

  private final T startObject;

  public Bucket(T startObject, T endObject) {
    this.startObject = startObject;
    this.endObject = endObject;
  }

  public T getEndObject() {
    return endObject;
  }

  public T getStartObject() {
    return startObject;
  }
}
