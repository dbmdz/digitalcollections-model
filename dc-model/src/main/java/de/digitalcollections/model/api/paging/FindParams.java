package de.digitalcollections.model.api.paging;

/** Container (DTO) for find parameters. */
public interface FindParams {

  String getNullHandling();

  int getPageNumber();

  int getPageSize();

  String getSortDirection();

  String getSortField();
}
