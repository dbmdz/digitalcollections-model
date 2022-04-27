package de.digitalcollections.model.jackson.paging;

import de.digitalcollections.model.filter.FilterCriterion;
import de.digitalcollections.model.filter.FilterOperation;
import de.digitalcollections.model.filter.Filtering;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.paging.PageRequest;
import de.digitalcollections.model.paging.PageResponse;
import de.digitalcollections.model.security.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PageResponseTest extends BaseJsonSerializationTest {

  private PageResponse<User> createObject() {
    List<User> content = new ArrayList<>();
    User user = new User();
    user.setEmail("test@user.de");
    content.add(user);
    PageResponse pageResponse = new PageResponse(content);

    PageRequest pageRequest = new PageRequest(3, 15);
    // filtering
    FilterCriterion filterCriteria1 =
        new FilterCriterion("longField", FilterOperation.EQUALS, 5L, null, null, null);
    FilterCriterion filterCriteria2 =
        new FilterCriterion(
            "dateField",
            FilterOperation.BETWEEN,
            null,
            LocalDate.parse("2020-01-01"),
            LocalDate.parse("2020-01-31"),
            null);
    Filtering filtering = Filtering.builder().add(filterCriteria1).add(filterCriteria2).build();
    pageRequest.setFiltering(filtering);
    pageResponse.setPageRequest(pageRequest);

    return pageResponse;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    PageResponse<User> pageResponse = createObject();
    checkSerializeDeserialize(pageResponse, "serializedTestObjects/paging/PageResponse.json");
    // TODO try to eliminate "className" : "de.digitalcollections.model.security.User" from
    // serialization. seems complicated:
    // https://stackoverflow.com/questions/34193177/why-does-jackson-polymorphic-serialization-not-work-in-lists
  }
}
