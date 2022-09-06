package de.digitalcollections.model.time;

public class TimeValueRange {

  private TimeValue end;
  private TimeValue start;

  public TimeValueRange() {}

  public TimeValueRange(TimeValue start, TimeValue end) {
    this.end = end;
    this.start = start;
  }

  public TimeValue getEnd() {
    return end;
  }

  public TimeValue getStart() {
    return start;
  }

  public void setEnd(TimeValue end) {
    this.end = end;
  }

  public void setStart(TimeValue start) {
    this.start = start;
  }
}
