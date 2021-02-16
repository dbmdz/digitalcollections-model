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

public class PagingTest extends BaseJsonSerializationTest {

  private List<User> createContent() {
    List<User> list = new ArrayList<>();
    User user = new User();
    user.setEmail("test@user.de");
    list.add(user);
    return list;
  }

  @Test
  public void testSerializeDeserializePageResponse() throws Exception {
    // List<T> content, PageRequest pageRequest, long total
    List<User> content = createContent();
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
    Filtering filtering =
        Filtering.defaultBuilder().add(filterCriteria1).add(filterCriteria2).build();
    pageRequest.setFiltering(filtering);

    pageResponse.setPageRequest(pageRequest);
    checkSerializeDeserialize(pageResponse);
  }
}
