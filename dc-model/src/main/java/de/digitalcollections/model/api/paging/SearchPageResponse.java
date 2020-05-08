package de.digitalcollections.model.api.paging;

public interface SearchPageResponse<T> extends PageResponse<T> {

  String getQuery();

  void setQuery(String query);
}
