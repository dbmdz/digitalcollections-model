package de.digitalcollections.model.jackson.filter;

import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import de.digitalcollections.model.impl.filter.FilterCriteriaImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class FilteringTest extends BaseJsonSerializationTest {

  private Filtering createContent() {
    FilterCriteria<Long> filterCriteria1 =
        new FilterCriteriaImpl<>("longField", FilterOperation.EQUALS, 5L, null, null, null);
    FilterCriteria<LocalDate> filterCriteria2 =
        new FilterCriteriaImpl<>(
            "dateField",
            FilterOperation.BETWEEN,
            null,
            LocalDate.parse("2020-01-01"),
            LocalDate.parse("2020-01-31"),
            null);

    Filtering filtering =
        Filtering.defaultBuilder().add(filterCriteria1).add(filterCriteria2).build();
    return filtering;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    Filtering content = createContent();
    checkSerializeDeserialize(content);
  }
}
