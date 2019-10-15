package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.FindParams;
import de.digitalcollections.model.api.paging.Order;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.Sorting;
import java.util.Iterator;

public class FindParamsImpl implements FindParams {

  public FindParamsImpl(PageRequest pageRequest) {
    int pageNumber = pageRequest.getPageNumber();
    int pageSize = pageRequest.getPageSize();

    Sorting sorting = pageRequest.getSorting();
    Iterator<Order> iterator = sorting.iterator();

    String sortField = "";
    String sortDirection = "";
    String nullHandling = "";

    if (iterator.hasNext()) {
      Order order = iterator.next();
      sortField = order.getProperty() == null ? "" : order.getProperty();
      sortDirection = order.getDirection() == null ? "" : order.getDirection().name();
      nullHandling = order.getNullHandling() == null ? "" : order.getNullHandling().name();
    }

    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
    this.sortField = sortField;
    this.sortDirection = sortDirection;
    this.nullHandling = nullHandling;
  }

  public FindParamsImpl(
      int pageNumber, int pageSize, String sortField, String sortDirection, String nullHandling) {
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
    this.sortField = sortField;
    this.sortDirection = sortDirection;
    this.nullHandling = nullHandling;
  }

  final int pageNumber;
  final int pageSize;
  final String sortField;
  final String sortDirection;
  final String nullHandling;

  @Override
  public int getPageNumber() {
    return pageNumber;
  }

  @Override
  public int getPageSize() {
    return pageSize;
  }

  @Override
  public String getSortField() {
    return sortField;
  }

  @Override
  public String getSortDirection() {
    return sortDirection;
  }

  @Override
  public String getNullHandling() {
    return nullHandling;
  }
}
