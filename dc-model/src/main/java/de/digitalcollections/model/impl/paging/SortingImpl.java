package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.paging.enums.Direction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * SortingImpl option for queries. You have to provide at least a list of properties to sort for
 * that must not include {@literal null} or empty strings. The direction defaults to {@link
 * Sorting#DEFAULT_DIRECTION}. See Spring Data Commons, but more flat design and independent of
 * Spring libraries.
 */
public class SortingImpl implements Sorting {

  private List<Order> orders;

  public SortingImpl() {}

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  /**
   * Creates a new {@link Sorting} instance using the given {@link Order}s.
   *
   * @param orders must not be {@literal null}.
   */
  public SortingImpl(Order... orders) {
    this(Arrays.asList(orders));
  }

  /**
   * Creates a new {@link Sorting} instance.
   *
   * @param orders must not be {@literal null} or contain {@literal null}.
   */
  public SortingImpl(List<Order> orders) {

    if (null == orders || orders.isEmpty()) {
      throw new IllegalArgumentException(
          "You have to provide at least one sort property to sort by!");
    }

    this.orders = orders;
  }

  /**
   * Creates a new {@link Sorting} instance. Order defaults to Direction#ASC.
   *
   * @param properties must not be {@literal null} or contain {@literal null} or empty strings
   */
  public SortingImpl(String... properties) {
    this(DEFAULT_DIRECTION, properties);
  }

  /**
   * Creates a new {@link Sorting} instance.
   *
   * @param direction defaults to {@link Sorting#DEFAULT_DIRECTION} (for {@literal null} cases, too)
   * @param properties must not be {@literal null}, empty or contain {@literal null} or empty
   *     strings.
   */
  public SortingImpl(Direction direction, String... properties) {
    this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
  }

  /**
   * Creates a new {@link Sorting} instance.
   *
   * @param direction defaults to {@link Sorting#DEFAULT_DIRECTION} (for {@literal null} cases, too)
   * @param properties must not be {@literal null} or contain {@literal null} or empty strings.
   */
  public SortingImpl(Direction direction, List<String> properties) {

    if (properties == null || properties.isEmpty()) {
      throw new IllegalArgumentException("You have to provide at least one property to sort by!");
    }

    this.orders = new ArrayList<>(properties.size());

    for (String property : properties) {
      this.orders.add(new OrderImpl(direction, property));
    }
  }

  /**
   * Returns a new {@link SortingImpl} consisting of the {@link Order}s of the current {@link
   * SortingImpl} combined with the given ones.
   *
   * @param sort can be {@literal null}.
   * @return a new combined sort
   */
  @Override
  public Sorting and(Sorting sort) {

    if (sort == null) {
      return this;
    }

    ArrayList<Order> these = new ArrayList<>(this.orders);

    for (Order order : sort) {
      these.add(order);
    }

    return new SortingImpl(these);
  }

  private String collectionToCommaDelimitedString(List<Order> coll) {
    if (coll == null || coll.isEmpty()) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    Iterator<?> it = coll.iterator();
    while (it.hasNext()) {
      sb.append("").append(it.next()).append("");
      if (it.hasNext()) {
        sb.append(",");
      }
    }
    return sb.toString();
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof SortingImpl)) {
      return false;
    }

    SortingImpl that = (SortingImpl) obj;

    return this.orders.equals(that.orders);
  }

  /**
   * Returns the order registered for the given property.
   *
   * @param property given property
   * @return the order registered for the given property
   */
  @Override
  public Order getOrderFor(String property) {

    for (Order order : this) {
      if (order.getProperty().equals(property)) {
        return order;
      }
    }

    return null;
  }

  @Override
  public int hashCode() {

    int result = 17;
    result = 31 * result + orders.hashCode();
    return result;
  }

  @Override
  public Iterator<Order> iterator() {
    return this.orders.iterator();
  }

  @Override
  public String toString() {
    return collectionToCommaDelimitedString(orders);
  }
}
