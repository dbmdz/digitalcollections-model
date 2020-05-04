package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.paging.enums.Direction;
import java.io.Serializable;

/**
 * Basic Java Bean implementation of {@code PageRequest}. See Spring Data Commons, but more flat
 * design and independent of Spring libraries.
 */
public class PageRequestImpl implements PageRequest, Serializable {

  private int pageNumber;
  private int pageSize;
  private Filtering filtering;
  private Sorting sort;

  public PageRequestImpl() {}

  /**
   * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing 0 for {@code page}
   * will return the first page.
   *
   * @param pageNumber zero-based page index.
   * @param pageSize the size of the page to be returned.
   */
  public PageRequestImpl(int pageNumber, int pageSize) {
    this(pageNumber, pageSize, null, (Filtering) null);
  }

  /**
   * Creates a new {@link PageRequest} with sort parameters applied.
   *
   * @param pageNumber zero-based page index.
   * @param pageSize the size of the page to be returned.
   * @param direction the direction of the {@link SortingImpl} to be specified, can be {@literal
   *     null}.
   * @param properties the properties to sort by, must not be {@literal null} or empty.
   */
  public PageRequestImpl(int pageNumber, int pageSize, Direction direction, String... properties) {
    this(pageNumber, pageSize, new SortingImpl(direction, properties), null);
  }

  public PageRequestImpl(int pageNumber, int pageSize, Sorting sort) {
    this(pageNumber, pageSize, sort, null);
  }

  /**
   * Creates a new {@link PageRequest} with sort parameters applied.
   *
   * @param pageNumber zero-based page index, must not be less than zero.
   * @param pageSize the size of the page to be returned, must not be less than one.
   * @param sort can be {@literal null}
   * @param filtering contains list of filter criterias
   */
  public PageRequestImpl(int pageNumber, int pageSize, Sorting sort, Filtering filtering) {
    if (pageNumber < 0) {
      throw new IllegalArgumentException("Page index must not be less than zero!");
    }

    if (pageSize < 1) {
      throw new IllegalArgumentException("Page size must not be less than one!");
    }

    this.filtering = filtering;
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
    this.sort = sort;
  }

  @Override
  public boolean equals(final Object obj) {

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof PageRequestImpl)) {
      return false;
    }

    PageRequestImpl that = (PageRequestImpl) obj;

    boolean filterEqual =
        (this.filtering == null ? that.filtering == null : this.filtering.equals(that.filtering));
    boolean sortEqual = (this.sort == null ? that.sort == null : this.sort.equals(that.sort));
    boolean othersEqual = (this.pageNumber == that.pageNumber && this.pageSize == that.pageSize);

    return filterEqual && othersEqual && sortEqual;
  }

  @Override
  public PageRequest first() {
    return new PageRequestImpl(0, getPageSize(), getSorting(), getFiltering());
  }

  @Override
  public Filtering getFiltering() {
    return filtering;
  }

  @Override
  public int getOffset() {
    return pageNumber * pageSize;
  }

  @Override
  public int getPageNumber() {
    return pageNumber;
  }

  @Override
  public int getPageSize() {
    return pageSize;
  }

  @Override
  public Sorting getSorting() {
    return sort;
  }

  @Override
  public boolean hasPrevious() {
    return pageNumber > 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + pageNumber;
    result = prime * result + pageSize;

    return 31 * result + (null == sort ? 0 : sort.hashCode());
  }

  @Override
  public PageRequest next() {
    return new PageRequestImpl(getPageNumber() + 1, getPageSize(), getSorting());
  }

  /**
   * Returns the {@link PageResponse} requesting the previous page.
   *
   * @return the PageResponse requesting the previous page
   */
  public PageRequest previous() {
    return getPageNumber() == 0
        ? this
        : new PageRequestImpl(getPageNumber() - 1, getPageSize(), getSorting());
  }

  @Override
  public PageRequest previousOrFirst() {
    return hasPrevious() ? previous() : first();
  }

  @Override
  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  @Override
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public void setSorting(Sorting sort) {
    this.sort = sort;
  }

  @Override
  public void setFiltering(Filtering filtering) {
    this.filtering = filtering;
  }

  @Override
  public String toString() {
    return String.format(
        "Page request [number: %d, size %d, sort: %s, filtering: %s]",
        getPageNumber(),
        getPageSize(),
        sort == null ? null : sort.toString(),
        filtering == null ? null : filtering.toString());
  }
}
