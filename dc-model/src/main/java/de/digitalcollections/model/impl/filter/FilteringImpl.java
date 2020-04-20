package de.digitalcollections.model.impl.filter;

import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.Filtering;
import java.util.Iterator;
import java.util.List;

public class FilteringImpl implements Filtering {

  private List<FilterCriteria> filterCriterias;

  public FilteringImpl(List<FilterCriteria> filterCriterias) {
    this.filterCriterias = filterCriterias;
  }

  @Override
  public FilterCriteria getFilterCriteriaFor(String property) {
    return filterCriterias.stream()
        .filter(
            f -> {
              return f.getFieldName().equals(property);
            })
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<FilterCriteria> getFilterCriterias() {
    return filterCriterias;
  }

  @Override
  public Iterator<FilterCriteria> iterator() {
    return filterCriterias.iterator();
  }
}
