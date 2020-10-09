package de.digitalcollections.model.impl.filter;

import de.digitalcollections.model.api.filter.FilterCriterion;
import de.digitalcollections.model.api.filter.Filtering;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilteringImpl implements Filtering {

  private List<FilterCriterion> filterCriteria = new ArrayList<>();

  public FilteringImpl() {}

  public FilteringImpl(List<FilterCriterion> filterCriteria) {
    this.filterCriteria = filterCriteria;
  }

  @Override
  public List<FilterCriterion> getFilterCriteria() {
    return filterCriteria;
  }

  @Override
  public FilterCriterion getFilterCriterionFor(String property) {
    return filterCriteria.stream()
        .filter(f -> f.getFieldName().equals(property))
        .findFirst()
        .orElse(null);
  }

  @Override
  public Iterator<FilterCriterion> iterator() {
    return filterCriteria.iterator();
  }

  @Override
  public void setFilterCriteria(List<FilterCriterion> filterCriteria) {
    this.filterCriteria = filterCriteria;
  }
}
