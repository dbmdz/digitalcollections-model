package de.digitalcollections.model.feign.expander.paging;

import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.Sorting;
import feign.Param;
import java.util.Iterator;

public class SortingToUrlParamsExpander implements Param.Expander {

  @Override
  public String expand(Object sortingObj) {
    if (sortingObj == null) {
      return "";
    }
    Sorting sorting = (Sorting) sortingObj;

    if (sorting.getOrders() != null && sorting.getOrders().size() > 1) {
      // TODO until now only one Order param is supported
      throw new IllegalArgumentException("only one order is supported");
    }

    Iterator<Order> iterator = sorting.iterator();
    if (iterator.hasNext()) {
      Order order = iterator.next();
      String sortField = order.getProperty() == null ? "" : order.getProperty();
      String sortDirection = order.getDirection() == null ? "" : order.getDirection().name();
      String nullHandling = order.getNullHandling() == null ? "" : order.getNullHandling().name();
      return String.format(
          "&sortField=%s&sortDirection=%s&nullHandling=%s", sortField, sortDirection, nullHandling);
    }
    return "";
  }
}
