package de.digitalcollections.model.jackson.list.filtering;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.list.filtering.FilterCriterion;
import de.digitalcollections.model.list.filtering.FilterOperation;
import de.digitalcollections.model.list.filtering.Filtering;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class FilteringTest extends BaseJsonSerializationTest {

  private Filtering createObject() {
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
    return filtering;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    Filtering filtering = createObject();
    checkSerializeDeserialize(filtering, "serializedTestObjects/list/filtering/Filtering.json");
  }
}