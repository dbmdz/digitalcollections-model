package de.digitalcollections.model.feign.encoder.paging;

import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.Sorting;
import feign.QueryMapEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SortingToQueryMapEncoder implements QueryMapEncoder {

  @Override
  public Map<String, Object> encode(Object object) {
    if (object == null) {
      return null;
    }
    Sorting sorting = (Sorting) object;
    if (sorting.getOrders() != null && sorting.getOrders().size() > 1) {
      // TODO until now only one Order param is supported
      throw new IllegalArgumentException("only one order is supported");
    }

    Map<String, Object> queryMap = new HashMap<>();
    for (Iterator<Order> iterator = sorting.iterator(); iterator.hasNext(); ) {
      Order order = iterator.next();
      String sortField = order.getProperty() == null ? "" : order.getProperty();
      queryMap.put("sortField", sortField);

      String sortDirection = order.getDirection() == null ? "" : order.getDirection().name();
      queryMap.put("sortDirection", sortDirection);

      String nullHandling = order.getNullHandling() == null ? "" : order.getNullHandling().name();
      queryMap.put("nullHandling", nullHandling);
    }
    return queryMap;
  }
}
