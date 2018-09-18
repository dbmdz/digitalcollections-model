package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.PagingInfo;
import java.util.ArrayList;
import java.util.List;

public class PagingInfoImpl implements PagingInfo {

  private final int maxPageItemsToDisplay;
  private final List<PageItem> items;
  private final int currentNumber;
  private final long totalItems;
  private final int totalPages;
  private final int pageSize;
  private String url;

  /**
   * PagingInfo
   * @param totalItems Total number of items to be paged
   * @param currentPage Number of the current page, starting with 0
   * @param totalPages maximum page number
   * @param maxPageItemsToDisplay maximum number of page items to be displayed
   * @param pageSize page size
   * @param url Base url
   */
  public PagingInfoImpl(long totalItems, int currentPage, int totalPages, int maxPageItemsToDisplay, int pageSize, String url) {
    this.totalItems = totalItems;
    this.totalPages = totalPages;
    this.maxPageItemsToDisplay = maxPageItemsToDisplay;
    this.pageSize = pageSize;
    this.url = url;
    items = new ArrayList<>();

    currentNumber = currentPage + 1; // start from 1 to match page.page

    int start;
    int size;
    if (totalPages <= maxPageItemsToDisplay) {
      start = 1;
      size = totalPages;
    } else if (currentNumber <= maxPageItemsToDisplay - maxPageItemsToDisplay / 2) {
      start = 1;
      size = maxPageItemsToDisplay;
    } else if (currentNumber >= totalPages - maxPageItemsToDisplay / 2) {
      start = totalPages - maxPageItemsToDisplay + 1;
      size = maxPageItemsToDisplay;
    } else {
      start = currentNumber - maxPageItemsToDisplay / 2;
      size = maxPageItemsToDisplay;
    }

    for (int i = 0; i < size; i++) {
      items.add(new PageItem(start + i, (start + i) == currentNumber));
    }
  }

  @Override
  public long getTotalItems() {
    return totalItems;
  }

  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public List<PageItem> getItems() {
    return items;
  }

  @Override
  public int getNumber() {
    return currentNumber;
  }

  @Override
  public int getSize() {
    return pageSize;
  }

  @Override
  public int getTotalPages() {
    return totalPages;
  }

  @Override
  public boolean isFirstPage() {
    return currentNumber == 1;
  }

  @Override
  public boolean isLastPage() {
    return currentNumber == totalPages;
  }

  @Override
  public boolean isHasPreviousPage() {
    return currentNumber > 1;
  }

  @Override
  public boolean isHasNextPage() {
    return currentNumber < totalPages;

  }

  public class PageItem {

    private final int number;
    private final boolean current;

    public PageItem(int number, boolean current) {
      this.number = number;
      this.current = current;
    }

    public int getNumber() {
      return this.number;
    }

    public boolean isCurrent() {
      return this.current;
    }
  }
}
