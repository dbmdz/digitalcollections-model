package de.digitalcollections.model.api.filter;

import de.digitalcollections.model.api.filter.enums.FilterOperation;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FilterCriteriaTest {

  @Test
  public void testGetConvertedSingleValue() {
    FilterCriteria criteria = new FilterCriteria("publicationStart", "gt:2020-04-10", LocalDate.class);
    assertEquals("publicationStart", criteria.getFieldName());
    assertEquals(FilterOperation.GREATER_THAN, criteria.getOperation());
    assertEquals(LocalDate.parse("2020-04-10"), criteria.getConvertedSingleValue());
  }
  
  @Test
  public void testBetween() {
    FilterCriteria criteria = new FilterCriteria("publicationDate", "btn:2020-03-01,2020-03-31", LocalDate.class);
    assertEquals("publicationDate", criteria.getFieldName());
    assertEquals(FilterOperation.BETWEEN, criteria.getOperation());
    assertEquals(LocalDate.parse("2020-03-01"), criteria.getMinValue());
    assertEquals(LocalDate.parse("2020-03-31"), criteria.getMaxValue());
  }
}
