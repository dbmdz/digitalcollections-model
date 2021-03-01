package de.digitalcollections.model.paging;

import de.digitalcollections.model.filter.Filtering;

public class PageRequestBuilder {

  private Filtering filtering;

  private int pageNumber;
  private int pageSize;
  private Sorting sorting;

  public PageRequest build() {
    return new PageRequest(pageNumber, pageSize, sorting, filtering);
  }

  public PageRequestBuilder filtering(Filtering filtering) {
    this.filtering = filtering;
    return this;
  }

  public PageRequestBuilder pageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

  public PageRequestBuilder pageSize(int pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  public PageRequestBuilder sorting(Sorting sorting) {
    this.sorting = sorting;
    return this;
  }
}
