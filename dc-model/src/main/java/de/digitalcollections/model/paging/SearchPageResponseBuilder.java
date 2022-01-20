package de.digitalcollections.model.paging;

import de.digitalcollections.model.identifiable.entity.Entity;

public class SearchPageResponseBuilder<T extends Entity>
    extends PageResponseBuilder<T, SearchPageResponse<T>, SearchPageResponseBuilder> {

  public SearchPageResponseBuilder() {
    pageResponse = new SearchPageResponse<>();
  }
}
