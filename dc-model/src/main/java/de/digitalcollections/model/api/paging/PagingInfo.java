package de.digitalcollections.model.api.paging;

import de.digitalcollections.model.api.paging.impl.PagingInfoImpl.PageItem;
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

  boolean isHasPreviousPage();

  boolean isHasNextPage();
}
