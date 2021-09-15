package de.digitalcollections.model.filter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FilterCriterionBuilderTest {

  public FilterCriterionBuilderTest() {}

  @Test
  public void testIsEquals() {
    Filtering filtering =
        new FilterCriterionBuilder("test", Filtering.defaultBuilder()).isEquals(null).build();
    assertEquals(FilterOperation.NOT_SET, filtering.getFilterCriteria().get(0).getOperation());
  }

  @Test
  public void testNotEquals() {
    Filtering filtering =
        new FilterCriterionBuilder("test", Filtering.defaultBuilder()).notEquals(null).build();
    assertEquals(FilterOperation.SET, filtering.getFilterCriteria().get(0).getOperation());
  }
}
