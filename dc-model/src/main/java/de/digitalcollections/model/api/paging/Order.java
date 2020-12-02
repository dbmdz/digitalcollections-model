package de.digitalcollections.model.api.paging;

import de.digitalcollections.model.api.paging.enums.Direction;
import de.digitalcollections.model.api.paging.enums.NullHandling;
import de.digitalcollections.model.impl.paging.OrderImpl;
import java.util.Optional;

public interface Order {

  /**
   * Returns the order the property shall be sorted for.
   *
   * @return the order the property shall be sorted for
   */
  Direction getDirection();

  /**
   * Returns the used {@link NullHandling} hint, which can but may not be respected by the used
   * datastore.
   *
   * @return the used NullHandling hint, which can but may not be respected by the used datastore.
   */
  NullHandling getNullHandling();

  /**
   * Returns the property to order for.
   *
   * @return the property to order for
   */
  String getProperty();

  /**
   * Returns the optional sub property to order for.
   *
   * <p>A sub property is always related to the main property.
   *
   * @return the optional sub property to order for
   */
  Optional<String> getSubProperty();

  /**
   * Returns a new {@link Order} with case insensitive sorting enabled.
   *
   * @return a new Order with case insensitive sorting enabled
   */
  Order ignoreCase();

  /**
   * Returns whether sorting for this property shall be ascending.
   *
   * @return whether sorting for this property shall be ascending
   */
  boolean isAscending();

  /**
   * Returns whether sorting for this property shall be descending.
   *
   * @return whether sorting for this property shall be descending
   */
  boolean isDescending();

  /**
   * Returns whether or not the sort will be case sensitive.
   *
   * @return whether or not the sort will be case sensitive
   */
  boolean isIgnoreCase();

  /**
   * Returns a {@link Order} with {@link NullHandling#NULLS_FIRST} as null handling hint.
   *
   * @return an Order with NullHandling#NULLS_FIRST as null handling hint
   */
  Order nullsFirst();

  /**
   * Returns a {@link Order} with {@link NullHandling#NULLS_LAST} as null handling hint.
   *
   * @return an Order with NullHandling#NULLS_LAST as null handling hint.
   */
  Order nullsLast();

  /**
   * Returns a {@link Order} with {@link NullHandling#NATIVE} as null handling hint.
   *
   * @return an Order with NullHandling#NATIVE as null handling hint.
   */
  Order nullsNative();

  /**
   * Returns a new {@link Order} with the given {@link Direction}.
   *
   * @param direction given direction
   * @return a new Order with the given Direction
   */
  Order with(Direction direction);

  /**
   * Returns a {@link Order} with the given {@link NullHandling}.
   *
   * @param nullHandling can be null.
   * @return an Order with the given NullHandling
   */
  Order with(NullHandling nullHandling);

  /**
   * Returns a new {@link Sorting} instance for the given properties.
   *
   * @param properties given properties
   * @return a new SortingImpl for the given properties
   */
  Sorting withProperties(String... properties);

  /**
   * Returns a new {@link Order}
   *
   * @param property must not be {@literal null} or empty.
   * @return a new Order
   */
  Order withProperty(String property);

  static Builder defaultBuilder() {
    return new Builder();
  }

  class Builder {
    private Direction direction;
    private boolean ignoreCase;
    private NullHandling nullHandling;
    private String property;
    private Optional<String> subProperty;

    public Builder direction(Direction direction) {
      this.direction = direction;
      return this;
    }

    public Builder ignoreCase(boolean ignoreCase) {
      this.ignoreCase = ignoreCase;
      return this;
    }

    public Builder nullHandling(NullHandling nullHandling) {
      this.nullHandling = nullHandling;
      return this;
    }

    public Builder property(String property) {
      this.property = property;
      return this;
    }

    public Builder subProperty(String property) {
      this.subProperty = Optional.ofNullable(property);
      return this;
    }

    public Order build() {
      OrderImpl order = new OrderImpl(direction, ignoreCase, nullHandling, property);
      if (subProperty.isPresent()) {
        order.setSubProperty(subProperty.get());
      }
      return order;
    }
  }
}
