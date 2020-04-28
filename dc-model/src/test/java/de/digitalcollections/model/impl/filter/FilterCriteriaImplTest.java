package de.digitalcollections.model.impl.filter;

import static org.assertj.core.api.Assertions.*;

import de.digitalcollections.model.api.filter.FilterCriteria;
import de.digitalcollections.model.api.filter.Filtering;
import de.digitalcollections.model.api.filter.enums.FilterOperation;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class FilterCriteriaImplTest {

  @Test
  public void testAutoCorrectionOfMinMaxBetweenValues() throws Exception {
    FilterCriteria<LocalDate> filterCriteria =
        new FilterCriteriaImpl<>(
            "dateField",
            FilterOperation.BETWEEN,
            null,
            LocalDate.parse("2020-01-31"),
            LocalDate.parse("2020-01-01"),
            null);

    Filtering filtering = Filtering.defaultBuilder().add(filterCriteria).build();
    FilterCriteria<LocalDate> dateFieldCriteria = filtering.getFilterCriteriaFor("dateField");
    assertThat(dateFieldCriteria.getMinValue().isBefore(dateFieldCriteria.getMaxValue()));
  }
}
