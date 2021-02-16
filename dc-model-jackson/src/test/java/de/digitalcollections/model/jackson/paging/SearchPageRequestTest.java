package de.digitalcollections.model.jackson.paging;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.paging.PageRequest;
import de.digitalcollections.model.paging.SearchPageRequest;
import org.junit.jupiter.api.Test;

public class SearchPageRequestTest extends BaseJsonSerializationTest {

  @Test
  public void testSerializeDeserializePageResponse() throws Exception {
    PageRequest pageRequest = new SearchPageRequest("hallo", 3, 15, null);
    checkSerializeDeserialize(pageRequest);
  }
}
