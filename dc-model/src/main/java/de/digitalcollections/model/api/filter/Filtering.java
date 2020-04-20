package de.digitalcollections.model.api.filter;

import de.digitalcollections.model.impl.filter.FilteringImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Filtering extends Iterable<FilterCriteria>, Serializable {

  /**
   * Returns the filter criteria registered for the given property.
   *
   * @param property given property
   * @return the filter criteria registered for the given property
   */
  FilterCriteria getFilterCriteriaFor(String property);

  /** @return returns all filter criterias */
  List<FilterCriteria> getFilterCriterias();

  static Builder defaultBuilder() {
    return new Builder();
  }

  class Builder {

    private List<FilterCriteria> filterCriterias;

    public Builder add(FilterCriteria filterCriteria) {
      if (filterCriterias == null) {
        filterCriterias = new ArrayList<>();
      }
      filterCriterias.add(filterCriteria);
      return this;
    }

    public Filtering build() {
      return new FilteringImpl(filterCriterias);
    }
  }
}
