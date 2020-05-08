package de.digitalcollections.model.api.paging;

public interface SearchPageRequest extends PageRequest {

  String getQuery();

  void setQuery(String query);
}
