package de.digitalcollections.model.api.paging;

import de.digitalcollections.model.api.paging.enums.Direction;
import de.digitalcollections.model.impl.paging.SortingImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Sorting extends Iterable<Order>, Serializable {

  Direction DEFAULT_DIRECTION = Direction.ASC;

  /**
   * Returns a new {@link Sorting} consisting of the {@link Order}s of the current {@link Sorting}
   * combined with the given ones.
   *
   * @param sorting can be {@literal null}.
   * @return a new combined sort
   */
  Sorting and(Sorting sorting);

  /**
   * Returns the order registered for the given property.
   *
   * @param property given property
   * @return the order registered for the given property
   */
  Order getOrderFor(String property);

  List<Order> getOrders();

  static Builder defaultBuilder() {
    return new Builder();
  }

  class Builder {

    private List<Order> orders;

    public Builder order(Order order) {
      if (orders == null) {
        orders = new ArrayList<>();
      }
      orders.add(order);
      return this;
    }

    public Sorting build() {
      return new SortingImpl(orders);
    }
  }
}
