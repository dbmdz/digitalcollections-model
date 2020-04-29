package de.digitalcollections.model.impl.filter;

import de.digitalcollections.model.api.filter.FilterCriterion;
import de.digitalcollections.model.api.filter.Filtering;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilteringImpl implements Filtering {

  private List<FilterCriterion> filterCriterias = new ArrayList<>();

  public FilteringImpl() {}

  public FilteringImpl(List<FilterCriterion> filterCriterias) {
    this.filterCriterias = filterCriterias;
  }

  @Override
  public FilterCriterion getFilterCriterionFor(String property) {
    return filterCriterias.stream()
        .filter(
            f -> {
              return f.getFieldName().equals(property);
            })
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<FilterCriterion> getFilterCriterias() {
    return filterCriterias;
  }

  @Override
  public Iterator<FilterCriterion> iterator() {
    return filterCriterias.iterator();
  }
}
