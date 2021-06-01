package de.digitalcollections.model.jackson.paging;

import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.web.Webpage;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.paging.SearchPageResponse;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The SearchPageResponse")
public class SearchPageResponseTest extends BaseJsonSerializationTest {

  @Test
  @DisplayName("can serialize and deserialize different types")
  public void differentTypes() throws Exception {
    List<Identifiable> content = new ArrayList<>();
    DigitalObject digitalObject = new DigitalObject();
    digitalObject.setLabel("DigitalObject-Label");
    content.add(digitalObject);
    Webpage webpage = new Webpage();
    webpage.setLabel("Webpage-Label");
    content.add(webpage);

    SearchPageResponse<Identifiable> resp = new SearchPageResponse<>();
    resp.setContent(content);
    resp.setTotalElements(2);

    checkSerializeDeserialize(resp, "serializedTestObjects/paging/SearchPageResponse.json");
  }
}
