package de.digitalcollections.model.paging;

public class SearchPageRequest extends PageRequest {

  private String query;

  public SearchPageRequest() {
    super();
  }

  public SearchPageRequest(String searchTerm, int pageNumber, int pageSize) {
    this(searchTerm, pageNumber, pageSize, null);
  }

  public SearchPageRequest(String searchTerm, int pageNumber, int pageSize, Sorting sorting) {
    super(pageNumber, pageSize, sorting);
    this.query = searchTerm;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }
}
