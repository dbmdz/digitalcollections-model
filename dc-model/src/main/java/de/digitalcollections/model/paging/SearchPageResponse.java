package de.digitalcollections.model.paging;

import java.util.List;

public class SearchPageResponse<T> extends PageResponse<T> {

  private String query;

  public SearchPageResponse() {
    super();
  }

  public SearchPageResponse(List<T> content, SearchPageRequest searchPageRequest, long total) {
    super(content, searchPageRequest, total);
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }
}
