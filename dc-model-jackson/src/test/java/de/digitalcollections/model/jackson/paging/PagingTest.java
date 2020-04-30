package de.digitalcollections.model.jackson.paging;

import de.digitalcollections.model.api.filter.FilterCriterion;
import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.impl.paging.PageRequestImpl;
import de.digitalcollections.model.impl.paging.PageResponseImpl;
import de.digitalcollections.model.impl.security.UserImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PagingTest extends BaseJsonSerializationTest {

  private List<UserImpl> createContent() {
    List<UserImpl> list = new ArrayList<>();
    UserImpl user = new UserImpl();
    user.setEmail("test@user.de");
    list.add(user);
    return list;
  }

  @Test
  public void testSerializeDeserializePageResponse() throws Exception {
    // List<T> content, PageRequest pageRequest, long total
    List<UserImpl> content = createContent();
    PageResponseImpl pageResponse = new PageResponseImpl(content);

    PageRequest pageRequest = new PageRequestImpl(3, 15);

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
