package de.digitalcollections.model.api.paging;

import de.digitalcollections.model.impl.paging.PageRequestImpl;

/**
 * Abstract interface for pagination information.
 * See Spring Data Commons, but more flat design and independent of Spring libraries.
 */
public interface PageRequest {

  /**
   * Returns the page to be returned.
   *
   * @return the page to be returned.
   */
  int getPageNumber();

  /**
   * Returns the number of items to be returned.
   *
   * @return the number of items of that page
   */
  int getPageSize();

  /**
   * Returns the offset to be taken according to the underlying page and page size.
   *
   * @return the offset to be taken
   */
  int getOffset();

  /**
   * Returns the sorting parameters.
   *
   * @return the sorting parameters
   */
  Sorting getSorting();

  /**
   * Returns the {@link PageRequest} requesting the next page.
   *
   * @return the PageRequest requesting the next page
   */
  PageRequest next();

  /**
   * Returns the previous {@link PageRequest} or the first {@link PageRequest} if the current one already is the first one.
   *
   * @return the previous PageRequest or the first PageRequest if the current one already is the first one
   */
  PageRequest previousOrFirst();

  /**
   * Returns the {@link PageRequest} requesting the first page.
   *
   * @return the PageRequest requesting the first page
   */
  PageRequest first();

  /**
   * Returns whether there's a previous {@link PageRequest} we can access from the current one. Will return {@literal false} in case the current {@link PageRequest} already refers to the first page.
   *
   * @return whether there's a previous PageRequest
   */
  boolean hasPrevious();

  /**
   * Sets the number of items.
   *
   * @param pageSize the number of items of that page
   */
  void setPageSize(int pageSize);

  /**
   * Sets the sorting parameters.
   *
   * @param sorting the sorting parameters
   */
  void setSorting(Sorting sorting);

  static Builder defaultBuilder() {
    return new Builder();
  }

  class Builder {

    private int pageNumber;
    private int pageSize;
    private Sorting sorting;

    public Builder pageNumber(int pageNumber) {
      this.pageNumber = pageNumber;
      return this;
    }

    public Builder pageSize(int pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public Builder sorting(Sorting sorting) {
      this.sorting = sorting;
      return this;
    }

    public PageRequest build() {
      return new PageRequestImpl(pageNumber, pageSize, sorting);
    }
  }
}
