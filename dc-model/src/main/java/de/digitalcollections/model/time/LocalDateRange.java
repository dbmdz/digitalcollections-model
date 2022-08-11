package de.digitalcollections.model.time;

import java.time.LocalDate;

public class LocalDateRange {

  private LocalDate end;
  private LocalDate start;

  public LocalDateRange() {}

  public LocalDateRange(LocalDate start, LocalDate end) {
    this.end = end;
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public LocalDate getStart() {
    return start;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }
}
