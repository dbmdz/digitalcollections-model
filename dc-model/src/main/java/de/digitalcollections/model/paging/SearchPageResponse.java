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

  @Deprecated(since = "9.1.0", forRemoval = true)
  /** @deprecated use ((SearchPageRequest) getPageRequest()).getQuery() instead. */
  public String getQuery() {
    return query;
  }

  @Deprecated(since = "9.1.0", forRemoval = true)
  public void setQuery(String query) {
    this.query = query;
  }
}
