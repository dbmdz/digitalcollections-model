package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.paging.enums.Direction;
import java.io.Serializable;

/**
 * Basic Java Bean implementation of {@code PageRequest}.
 * See Spring Data Commons, but more flat design and independent of Spring libraries.
 */
public class PageRequestImpl implements PageRequest, Serializable {

  private int page;
  private int size;
  private Sorting sort;

  public PageRequestImpl() {
  }

  /**
   * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return the first
   * page.
   *
   * @param page zero-based page index.
   * @param size the size of the page to be returned.
   */
  public PageRequestImpl(int page, int size) {
    this(page, size, null);
  }

  /**
   * Creates a new {@link PageRequest} with sort parameters applied.
   *
   * @param page zero-based page index.
   * @param size the size of the page to be returned.
   * @param direction the direction of the {@link SortingImpl} to be specified, can be {@literal null}.
   * @param properties the properties to sort by, must not be {@literal null} or empty.
   */
  public PageRequestImpl(int page, int size, Direction direction, String... properties) {
    this(page, size, new SortingImpl(direction, properties));
  }

  /**
   * Creates a new {@link PageRequest} with sort parameters applied.
   *
   * @param page zero-based page index, must not be less than zero.
   * @param size the size of the page to be returned, must not be less than one.
   * @param sort can be {@literal null}.
   */
  public PageRequestImpl(int page, int size, Sorting sort) {
    if (page < 0) {
      throw new IllegalArgumentException("Page index must not be less than zero!");
    }

    if (size < 1) {
      throw new IllegalArgumentException("Page size must not be less than one!");
    }

    this.page = page;
    this.size = size;
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

    boolean sortEqual = (this.sort == null ? that.sort == null : this.sort.equals(that.sort));
    boolean othersEqual = (this.page == that.page && this.size == that.size);

    return othersEqual && sortEqual;
  }

  @Override
  public PageRequest first() {
    return new PageRequestImpl(0, getPageSize(), getSorting());
  }

  @Override
  public int getOffset() {
    return page * size;
  }

  @Override
  public int getPageNumber() {
    return page;
  }

  @Override
  public int getPageSize() {
    return size;
  }

  @Override
  public Sorting getSorting() {
    return sort;
  }

  @Override
  public boolean hasPrevious() {
    return page > 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + page;
    result = prime * result + size;

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
    return getPageNumber() == 0 ? this : new PageRequestImpl(getPageNumber() - 1, getPageSize(), getSorting());
  }

  @Override
  public PageRequest previousOrFirst() {
    return hasPrevious() ? previous() : first();
  }

  public void setPageNumber(int page) {
    this.page = page;
  }

  @Override
  public void setPageSize(int size) {
    this.size = size;
  }

  @Override
  public void setSorting(Sorting sort) {
    this.sort = sort;
  }

  @Override
  public String toString() {
    return String.format("Page request [number: %d, size %d, sort: %s]", getPageNumber(), getPageSize(), sort == null ? null : sort.toString());
  }
}
