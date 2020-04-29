package de.digitalcollections.model.impl.filter;

import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.Filtering;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilteringImpl<T extends Comparable> implements Filtering {

  private List<FilterCriteria<T>> filterCriterias = new ArrayList<>();

  public FilteringImpl() {}

  public FilteringImpl(List<FilterCriteria<T>> filterCriterias) {
    this.filterCriterias = filterCriterias;
  }

  @Override
  public FilterCriteria<T> getFilterCriteriaFor(String property) {
    return filterCriterias.stream()
        .filter(
            f -> {
              return f.getFieldName().equals(property);
            })
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<FilterCriteria<T>> getFilterCriterias() {
    return filterCriterias;
  }

  @Override
  public Iterator<FilterCriteria<T>> iterator() {
    return filterCriterias.iterator();
  }
}
