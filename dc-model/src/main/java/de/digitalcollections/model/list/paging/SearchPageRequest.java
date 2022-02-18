package de.digitalcollections.model.list.paging;

import de.digitalcollections.model.list.Sorting;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SearchPageRequest)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SearchPageRequest that = (SearchPageRequest) o;
    return Objects.equals(query, that.query);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), query);
  }
}
