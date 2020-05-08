package de.digitalcollections.model.jackson.paging;

import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.impl.paging.SearchPageRequestImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class SearchPageRequestTest extends BaseJsonSerializationTest {

  @Test
  public void testSerializeDeserializePageResponse() throws Exception {
    PageRequest pageRequest = new SearchPageRequestImpl("hallo", 3, 15, null);
    checkSerializeDeserialize(pageRequest);
  }
}
