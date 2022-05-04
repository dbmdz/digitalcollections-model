package de.digitalcollections.model.paging;

import de.digitalcollections.model.identifiable.entity.Entity;
import java.util.List;

public class SearchPageResponse<T> extends PageResponse<T> {

  private String query;

  public SearchPageResponse() {
    super();
  }

  public SearchPageResponse(List<T> content, SearchPageRequest searchPageRequest, long total) {
    super(content, searchPageRequest, total);
  }

  /**
   * @deprecated use ((SearchPageRequest) getPageRequest()).getQuery() instead.
   */
  @Deprecated(since = "9.1.0", forRemoval = true)
  public String getQuery() {
    return query;
  }

  /**
   * @param query query term
   * @deprecated use ((SearchPageRequest) getPageRequest()).setQuery() instead.
   */
  @Deprecated(since = "9.1.0", forRemoval = true)
  public void setQuery(String query) {
    this.query = query;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder<T extends Entity>
      extends PageResponse.Builder<T, SearchPageResponse<T>, Builder> {

    public Builder() {
      pageResponse = new SearchPageResponse<>();
    }
  }
}
