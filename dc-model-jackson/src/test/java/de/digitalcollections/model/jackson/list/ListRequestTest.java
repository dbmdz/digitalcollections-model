package de.digitalcollections.model.jackson.list;

import de.digitalcollections.model.filter.Filtering;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.list.ListRequest;
import de.digitalcollections.model.paging.Direction;
import de.digitalcollections.model.paging.Order;
import de.digitalcollections.model.paging.Sorting;
import org.junit.jupiter.api.Test;

public class ListRequestTest extends BaseJsonSerializationTest {

  private ListRequest createObject() {
    ListRequest listRequest = new ListRequest();
    listRequest.add(Filtering.defaultBuilder().filter("label").startsWith("A").build());
    listRequest.add(
        Sorting.defaultBuilder()
            .order(Order.defaultBuilder().direction(Direction.ASC).property("label").build())
            .build());
    return listRequest;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    ListRequest listRequest = createObject();
    checkSerializeDeserialize(listRequest, "serializedTestObjects/list/ListRequest.json");
  }
}
