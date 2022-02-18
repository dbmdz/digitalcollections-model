package de.digitalcollections.model.list;

import java.util.ArrayList;
import java.util.List;

public class SortingBuilder {

  private List<Order> orders;

  public Sorting build() {
    return new Sorting(orders);
  }

  public SortingBuilder order(Order order) {
    if (orders == null) {
      orders = new ArrayList<>();
    }
    orders.add(order);
    return this;
  }
}
