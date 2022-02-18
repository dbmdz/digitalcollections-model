package de.digitalcollections.model.jackson.list.paging;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.list.paging.PageRequest;
import de.digitalcollections.model.list.paging.SearchPageRequest;
import org.junit.jupiter.api.Test;

public class SearchPageRequestTest extends BaseJsonSerializationTest {

  private PageRequest createObject() {
    PageRequest pageRequest = new SearchPageRequest("hallo", 3, 15, null);
    return pageRequest;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    PageRequest pageRequest = createObject();
    checkSerializeDeserialize(
        pageRequest, "serializedTestObjects/list/paging/SearchPageRequest.json");
  }
}
