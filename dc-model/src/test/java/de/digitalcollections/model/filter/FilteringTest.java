package de.digitalcollections.model.filter;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

public class FilteringTest<T extends Object> {

  final LocalDate maxDate = LocalDate.parse("2200-12-31");
  final LocalDate minDate = LocalDate.parse("1970-01-01");

  public FilteringTest() {}

  @Test
  public void testGetFilterCriteriaFor() {
    String property = "publicationStart";
    Filtering filtering =
        Filtering.defaultBuilder().filter(property).between(minDate, maxDate).build();
    FilterCriterion fc = filtering.getFilterCriterionFor(property);
    assertEquals(fc.getMinValue(), minDate);
    assertEquals(fc.getMaxValue(), maxDate);
  }

  @Test
  public void testOperationEquals() {
    String property = "publicationStart";
    Filtering filtering = Filtering.defaultBuilder().filter(property).isEquals(minDate).build();
    FilterCriterion fc = filtering.getFilterCriterionFor(property);
    assertEquals(fc.getValue(), minDate);
  }

  @Test
  public void testOperationInWithDifferentValueObjects() {
    String property = "publicationStart";

    // String[]
    String[] values1 = new String[] {"eins", "zwei", "drei"};
    Filtering filtering =
        Filtering.defaultBuilder().filter(property).in(Arrays.asList(values1)).build();
    FilterCriterion fc = filtering.getFilterCriterionFor(property);
    assertEquals(fc.getValues().size(), values1.length);

    // ArrayList
    ArrayList<String> values2 = new ArrayList<>();
    values2.add("eins");
    values2.add("zwei");
    values2.add("drei");
    filtering = Filtering.defaultBuilder().filter(property).in(values2).build();
    fc = filtering.getFilterCriterionFor(property);
    assertEquals(fc.getValues().size(), values2.size());
  }
}
