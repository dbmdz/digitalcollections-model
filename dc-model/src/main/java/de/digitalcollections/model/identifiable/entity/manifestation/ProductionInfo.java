package de.digitalcollections.model.identifiable.entity.manifestation;

import de.digitalcollections.model.time.LocalDateRange;
import de.digitalcollections.model.time.TimeValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class ProductionInfo {

  private List<Publisher> publishers;
  private String datePresentation;
  private LocalDateRange dateRange;
  private TimeValueRange timeValueRange;

  public ProductionInfo() {}

  public List<Publisher> getPublishers() {
    return publishers;
  }

  public void setPublishers(List<Publisher> publishers) {
    this.publishers = publishers;
  }

  public String getDatePresentation() {
    return datePresentation;
  }

  public void setDatePresentation(String datePresentation) {
    this.datePresentation = datePresentation;
  }

  public LocalDateRange getDateRange() {
    return dateRange;
  }

  public void setDateRange(LocalDateRange dateRange) {
    this.dateRange = dateRange;
  }

  public TimeValueRange getTimeValueRange() {
    return timeValueRange;
  }

  public void setTimeValueRange(TimeValueRange timeValueRange) {
    this.timeValueRange = timeValueRange;
  }

  @Override
  public String toString() {
    return "ProductionInfo{"
        + "publishers="
        + publishers
        + ", datePresentation='"
        + datePresentation
        + '\''
        + ", dateRange="
        + dateRange
        + ", timeValueRange="
        + timeValueRange
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductionInfo)) {
      return false;
    }
    ProductionInfo that = (ProductionInfo) o;
    return Objects.equals(publishers, that.publishers)
        && Objects.equals(datePresentation, that.datePresentation)
        && Objects.equals(dateRange, that.dateRange)
        && Objects.equals(timeValueRange, that.timeValueRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publishers, datePresentation, dateRange, timeValueRange);
  }

  public abstract static class ProductionInfoBuilder<
      C extends ProductionInfo, B extends ProductionInfoBuilder<C, B>> {

    public B publisher(Publisher publisher) {
      if (publishers == null) {
        publishers = new ArrayList<>(1);
      }
      publishers.add(publisher);
      return self();
    }

    public C build() {
      C c = prebuild();
      return c;
    }
  }
}
