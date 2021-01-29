package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.SearchPageRequest;
import de.digitalcollections.model.api.paging.Sorting;

public class SearchPageRequestImpl extends PageRequestImpl implements SearchPageRequest {

  private String query;

  public SearchPageRequestImpl() {
    super();
  }

  public SearchPageRequestImpl(String searchTerm, int pageNumber, int pageSize) {
    this(searchTerm, pageNumber, pageSize, null);
  }

  public SearchPageRequestImpl(String searchTerm, int pageNumber, int pageSize, Sorting sorting) {
    super(pageNumber, pageSize, sorting);
    this.query = searchTerm;
  }

  @Override
  public String getQuery() {
    return query;
  }

  @Override
  public void setQuery(String query) {
    this.query = query;
  }
}
