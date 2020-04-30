package de.digitalcollections.model.api.paging;

import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.impl.paging.PageRequestImpl;

/**
 * Abstract interface for pagination information. See Spring Data Commons, but more flat design and
 * independent of Spring libraries.
 *
 * <p>Container for paging, sorting and filtering params:
 *
 * <ul>
 *   <li>pageNumber: which page to be returned
 *   <li>pageSize: how many items on one page
 *   <li>sorting: container for sorting order of result list
 *   <li>filtering: container for filter criterias of result list
 * </ul>
 */
public interface PageRequest {

  static Builder defaultBuilder() {
    return new Builder();
  }

  /** @return the {@link PageRequest} requesting the first page */
  PageRequest first();

  /** @param filtering the filtering criterias */
  void setFiltering(Filtering filtering);

  /** @return the filtering parameters */
  Filtering getFiltering();

  /** @return the offset to be taken according to the underlying page and page size. */
  int getOffset();

  /** @param pageNumber the page to be returned */
  void setPageNumber(int pageNumber);

  /** @return the page to be returned. */
  int getPageNumber();

  /** @param pageSize the number of items of that page */
  void setPageSize(int pageSize);

  /** @return the number of items of that page */
  int getPageSize();

  /** @param sorting the sorting parameters */
  void setSorting(Sorting sorting);

  /** @return the sorting parameters */
  Sorting getSorting();

  /**
   * Returns whether there's a previous {@link PageRequest} we can access from the current one. Will
   * return {@literal false} in case the current {@link PageRequest} already refers to the first
   * page.
   *
   * @return whether there's a previous PageRequest
   */
  boolean hasPrevious();

  /** @return the {@link PageRequest} requesting the next page */
  PageRequest next();

  /**
   * @return the previous {@link PageRequest} or the first {@link PageRequest} if the current one
   *     already is the first one
   */
  PageRequest previousOrFirst();

  class Builder {

    private int pageNumber;
    private int pageSize;
    private Sorting sorting;
    private Filtering filtering;

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

    public Builder filtering(Filtering filtering) {
      this.filtering = filtering;
      return this;
    }

    public PageRequest build() {
      return new PageRequestImpl(pageNumber, pageSize, sorting, filtering);
    }
  }
}
