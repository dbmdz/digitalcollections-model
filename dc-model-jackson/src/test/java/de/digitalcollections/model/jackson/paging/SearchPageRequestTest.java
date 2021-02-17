package de.digitalcollections.model.jackson.paging;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.paging.PageRequest;
import de.digitalcollections.model.paging.SearchPageRequest;
import org.junit.jupiter.api.Test;

public class SearchPageRequestTest extends BaseJsonSerializationTest {

  private PageRequest createObject() {
    PageRequest pageRequest = new SearchPageRequest("hallo", 3, 15, null);
    return pageRequest;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    PageRequest pageRequest = createObject();
    checkSerializeDeserialize(pageRequest, "serializedTestObjects/paging/SearchPageRequest.json");
  }
}
