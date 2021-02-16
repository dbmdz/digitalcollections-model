package de.digitalcollections.model.paging;

public class OrderBuilder {

  private Direction direction;
  private boolean ignoreCase;
  private NullHandling nullHandling;
  private String property;
  private String subProperty;

  public Order build() {
    Order order = new Order(direction, ignoreCase, nullHandling, property);
    if (subProperty != null) {
      order.setSubProperty(subProperty);
    }
    return order;
  }

  public OrderBuilder direction(Direction direction) {
    this.direction = direction;
    return this;
  }

  public OrderBuilder ignoreCase(boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
    return this;
  }

  public OrderBuilder nullHandling(NullHandling nullHandling) {
    this.nullHandling = nullHandling;
    return this;
  }

  public OrderBuilder property(String property) {
    this.property = property;
    return this;
  }

  public OrderBuilder subProperty(String property) {
    this.subProperty = property;
    return this;
  }
}
