package de.digitalcollections.model.api.paging;

import java.util.List;

public interface PagingInfo {

  long getTotalItems();

  String getUrl();

  List<PageItem> getItems();

  int getNumber();

  int getSize();

  int getTotalPages();

  boolean isFirstPage();

  boolean isLastPage();

  boolean hasPreviousPage();

  boolean hasNextPage();
}
