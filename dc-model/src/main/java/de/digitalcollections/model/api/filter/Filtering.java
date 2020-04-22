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

    /**
     * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no
     * filter criteria is added (null-safe)
     *
     * @param fieldName name of field (if field name could not be set during instantiation of
     *     FieldCriteria, e.g. during spring mvxc type conversion)
     * @param filterCriteria filter criteria to add
     * @return builder instance for fluent usage
     */
    public Builder add(String fieldName, FilterCriteria filterCriteria) {
      if (filterCriteria != null) {
        filterCriteria.setFieldName(fieldName);
      }
      return add(filterCriteria);
    }

    /**
     * adds a filter criteria to list of filter criterias. if given filterCriteria is null, no
     * filter criteria is added (null-safe)
     *
     * @param filterCriteria filter criteria to add
     * @return builder instance for fluent usage
     */
    public Builder add(FilterCriteria filterCriteria) {
      if (filterCriterias == null) {
        filterCriterias = new ArrayList<>();
      }
      if (filterCriteria != null) {
        if (filterCriteria.getFieldName() == null) {
          throw new IllegalArgumentException("field name of a filter criteria must not be null!");
        }
        filterCriterias.add(filterCriteria);
      }
      return this;
    }

    public Filtering build() {
      return new FilteringImpl(filterCriterias);
    }
  }
}
