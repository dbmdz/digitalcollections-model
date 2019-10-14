package de.digitalcollections.model.impl.paging;

import static de.digitalcollections.model.api.paging.Sorting.DEFAULT_DIRECTION;

import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.paging.enums.Direction;
import de.digitalcollections.model.api.paging.enums.NullHandling;

/**
 * PropertyPath implements the pairing of an {@link Direction} and a property. It is used to provide
 * input for {@link Sorting}. See Spring Data Commons, but more flat design and independent of
 * Spring libraries.
 */
public class OrderImpl implements Order {

  private static final boolean DEFAULT_IGNORE_CASE = false;

  private Direction direction;
  private boolean ignoreCase;
  private NullHandling nullHandling;
  private String property;

  public OrderImpl() {}

  public OrderImpl(
      Direction direction, boolean ignoreCase, NullHandling nullHandling, String property) {
    this.direction = direction;
    this.ignoreCase = ignoreCase;
    this.nullHandling = nullHandling;
    this.property = property;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void setIgnoreCase(boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
  }

  public void setNullHandling(NullHandling nullHandling) {
    this.nullHandling = nullHandling;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  /**
   * Creates a new {@link Order} instance. if order is {@literal null} then order defaults to {@link
   * SortingImpl#DEFAULT_DIRECTION}
   *
   * @param direction can be {@literal null}, will default to {@link SortingImpl#DEFAULT_DIRECTION}
   * @param property must not be {@literal null} or empty.
   */
  public OrderImpl(Direction direction, String property) {
    this(direction, property, DEFAULT_IGNORE_CASE, null);
  }

  /**
   * Creates a new {@link Order} instance. if order is {@literal null} then order defaults to {@link
   * SortingImpl#DEFAULT_DIRECTION}
   *
   * @param direction can be {@literal null}, will default to {@link SortingImpl#DEFAULT_DIRECTION}
   * @param property must not be {@literal null} or empty.
   * @param nullHandlingHint can be {@literal null}, will default to {@link NullHandling#NATIVE}.
   */
  public OrderImpl(Direction direction, String property, NullHandling nullHandlingHint) {
    this(direction, property, DEFAULT_IGNORE_CASE, nullHandlingHint);
  }

  /**
   * Creates a new {@link Order} instance. Takes a single property. Direction defaults to {@link
   * SortingImpl#DEFAULT_DIRECTION}.
   *
   * @param property must not be {@literal null} or empty.
   */
  public OrderImpl(String property) {
    this(Sorting.DEFAULT_DIRECTION, property);
  }

  /**
   * Creates a new {@link Order} instance. if order is {@literal null} then order defaults to {@link
   * SortingImpl#DEFAULT_DIRECTION}
   *
   * @param direction can be {@literal null}, will default to {@link Sorting#DEFAULT_DIRECTION}
   * @param property must not be {@literal null} or empty.
   * @param ignoreCase true if sorting should be case insensitive. false if sorting should be case
   *     sensitive.
   * @param nullHandling can be {@literal null}, will default to {@link NullHandling#NATIVE}.
   */
  private OrderImpl(
      Direction direction, String property, boolean ignoreCase, NullHandling nullHandling) {

    if (property == null || property.isEmpty() || property.trim().isEmpty()) {
      throw new IllegalArgumentException("Property must not null or empty!");
    }

    this.direction = direction == null ? DEFAULT_DIRECTION : direction;
    this.property = property;
    this.ignoreCase = ignoreCase;
    this.nullHandling = nullHandling == null ? NullHandling.NATIVE : nullHandling;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof OrderImpl)) {
      return false;
    }

    OrderImpl that = (OrderImpl) obj;

    return this.direction.equals(that.getDirection())
        && this.property.equals(that.getProperty())
        && this.ignoreCase == that.isIgnoreCase()
        && this.nullHandling.equals(that.getNullHandling());
  }

  /**
   * Returns the order the property shall be sorted for.
   *
   * @return the order the property shall be sorted for
   */
  @Override
  public Direction getDirection() {
    return direction;
  }

  /**
   * Returns the used {@link NullHandling} hint, which can but may not be respected by the used
   * datastore.
   *
   * @return the used NullHandling hint, which can but may not be respected by the used datastore.
   */
  @Override
  public NullHandling getNullHandling() {
    return nullHandling;
  }

  /**
   * Returns the property to order for.
   *
   * @return the property to order for
   */
  @Override
  public String getProperty() {
    return property;
  }

  @Override
  public int hashCode() {

    int result = 17;

    result = 31 * result + direction.hashCode();
    result = 31 * result + property.hashCode();
    result = 31 * result + (ignoreCase ? 1 : 0);
    result = 31 * result + nullHandling.hashCode();

    return result;
  }

  /**
   * Returns a new {@link Order} with case insensitive sorting enabled.
   *
   * @return a new Order with case insensitive sorting enabled
   */
  @Override
  public Order ignoreCase() {
    return new OrderImpl(direction, property, true, nullHandling);
  }

  /**
   * Returns whether sorting for this property shall be ascending.
   *
   * @return whether sorting for this property shall be ascending
   */
  @Override
  public boolean isAscending() {
    return this.direction.isAscending();
  }

  /**
   * Returns whether sorting for this property shall be descending.
   *
   * @return whether sorting for this property shall be descending
   */
  @Override
  public boolean isDescending() {
    return this.direction.isDescending();
  }

  /**
   * Returns whether or not the sort will be case sensitive.
   *
   * @return whether or not the sort will be case sensitive
   */
  @Override
  public boolean isIgnoreCase() {
    return ignoreCase;
  }

  /**
   * Returns a {@link Order} with {@link NullHandling#NULLS_FIRST} as null handling hint.
   *
   * @return an Order with NullHandling#NULLS_FIRST as null handling hint
   */
  @Override
  public Order nullsFirst() {
    return with(NullHandling.NULLS_FIRST);
  }

  /**
   * Returns a {@link Order} with {@link NullHandling#NULLS_LAST} as null handling hint.
   *
   * @return an Order with NullHandling#NULLS_LAST as null handling hint.
   */
  @Override
  public Order nullsLast() {
    return with(NullHandling.NULLS_LAST);
  }

  /**
   * Returns a {@link Order} with {@link NullHandling#NATIVE} as null handling hint.
   *
   * @return an Order with NullHandling#NATIVE as null handling hint.
   */
  @Override
  public Order nullsNative() {
    return with(NullHandling.NATIVE);
  }

  @Override
  public String toString() {

    String result = String.format("%s: %s", property, direction);

    if (!NullHandling.NATIVE.equals(nullHandling)) {
      result += ", " + nullHandling;
    }

    if (ignoreCase) {
      result += ", ignoring case";
    }

    return result;
  }

  /**
   * Returns a new {@link Order} with the given {@link Direction}.
   *
   * @param direction given direction
   * @return a new Order with the given Direction
   */
  @Override
  public Order with(Direction direction) {
    return new OrderImpl(direction, this.property, this.ignoreCase, this.nullHandling);
  }

  /**
   * Returns a {@link Order} with the given {@link NullHandling}.
   *
   * @param nullHandling can be null.
   * @return an Order with the given NullHandling
   */
  @Override
  public Order with(NullHandling nullHandling) {
    return new OrderImpl(direction, this.property, ignoreCase, nullHandling);
  }

  /**
   * Returns a new {@link Sorting} instance for the given properties.
   *
   * @param properties given properties
   * @return a new SortingImpl for the given properties
   */
  @Override
  public Sorting withProperties(String... properties) {
    return new SortingImpl(this.direction, properties);
  }

  /**
   * Returns a new {@link Order}
   *
   * @param property must not be {@literal null} or empty.
   * @return a new Order
   */
  @Override
  public Order withProperty(String property) {
    return new OrderImpl(this.direction, property, this.ignoreCase, this.nullHandling);
  }
}
