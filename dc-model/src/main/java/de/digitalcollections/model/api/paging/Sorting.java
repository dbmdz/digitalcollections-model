package de.digitalcollections.model.api.paging;

import de.digitalcollections.model.api.paging.enums.Direction;
import java.io.Serializable;

public interface Sorting extends Iterable<Order>, Serializable {

  Direction DEFAULT_DIRECTION = Direction.ASC;

  /**
   * Returns a new {@link Sorting} consisting of the {@link Order}s of the current {@link Sorting} combined with the given
   * ones.
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
}
