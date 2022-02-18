package de.digitalcollections.model.list;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class FilterCriterionTest {

  @Test
  public void testAutoCorrectionOfMinMaxBetweenValues() throws Exception {
    FilterCriterion filterCriterion =
        new FilterCriterion(
            "dateField",
            FilterOperation.BETWEEN,
            null,
            LocalDate.parse("2020-01-31"),
            LocalDate.parse("2020-01-01"),
            null);

    Filtering filtering = Filtering.defaultBuilder().add(filterCriterion).build();
    FilterCriterion dateFieldCriteria = filtering.getFilterCriterionFor("dateField");
    assertTrue(
        ((ChronoLocalDate) dateFieldCriteria.getMinValue())
            .isBefore(((ChronoLocalDate) dateFieldCriteria.getMaxValue())));
  }

  @Test
  public void testConstructorValidation() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              new FilterCriterion(
                  "dateField",
                  FilterOperation.BETWEEN,
                  null,
                  LocalDate.parse("2020-01-31"),
                  LocalDate.parse("2020-01-01"),
                  Arrays.asList("1"));
            });
    String expectedMessage = "operation requires exactly one min and one max value!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.equals(expectedMessage));

    exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              new FilterCriterion(
                  "dateField",
                  FilterOperation.NOT_SET,
                  null,
                  LocalDate.parse("2020-01-31"),
                  null,
                  null);
            });
    expectedMessage = "operation does not support operand values!";
    actualMessage = exception.getMessage();
    assertTrue(actualMessage.equals(expectedMessage));
  }
}
