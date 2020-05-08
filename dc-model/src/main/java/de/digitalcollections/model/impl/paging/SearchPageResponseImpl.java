package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.SearchPageRequest;
import de.digitalcollections.model.api.paging.SearchPageResponse;
import java.util.List;

public class SearchPageResponseImpl<T> extends PageResponseImpl<T>
    implements SearchPageResponse<T> {

  private String query;

  public SearchPageResponseImpl() {
    super();
  }

  public SearchPageResponseImpl(List<T> content, SearchPageRequest searchPageRequest, long total) {
    super(content, searchPageRequest, total);
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
