package de.digitalcollections.model.feign.expander.paging;

import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.feign.expander.filter.FilteringToUrlParamsExpander;
import feign.Param;

public class PageRequestToUrlParamsExpander<T extends Comparable> implements Param.Expander {

  private FilteringToUrlParamsExpander<T> filteringToUrlParamsExpander =
      new FilteringToUrlParamsExpander<>();
  private SortingToUrlParamsExpander sortingToUrlParamsExpander = new SortingToUrlParamsExpander();

  @Override
  public String expand(Object pageRequestObj) {
    if (pageRequestObj == null) {
      return "";
    }
    PageRequest pageRequest = (PageRequest) pageRequestObj;

    StringBuilder sb = new StringBuilder();

    // info: each expander expands to a String with leading "&"
    // paging
    int pageNumber = pageRequest.getPageNumber();
    if (pageNumber > -1) {
      sb.append(String.format("&pageNumber=%s", pageNumber));
    }
    int pageSize = pageRequest.getPageSize();
    if (pageSize > -1) {
      sb.append(String.format("&pageSize=%s", pageSize));
    }

    // sorting
    Sorting sorting = pageRequest.getSorting();
    sb.append(sortingToUrlParamsExpander.expand(sorting));

    // filtering
    Filtering filtering = pageRequest.getFiltering();
    sb.append(filteringToUrlParamsExpander.expand(filtering));

    String urlParams = sb.toString();
    if (urlParams.endsWith(",")) {
      urlParams = urlParams.substring(0, urlParams.lastIndexOf(","));
    }
    if (urlParams.startsWith("&")) {
      // cut off leading "&"
      urlParams = urlParams.substring(1);
    }
    return urlParams;
  }
}
