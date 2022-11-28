package de.digitalcollections.model.identifiable.entity.manifestation;

import de.digitalcollections.model.time.LocalDateRange;
import de.digitalcollections.model.time.TimeValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class PublicationInfo {

  private List<Publisher> publishers;
  private String datePresentation;
  private LocalDateRange dateRange;
  private TimeValueRange timeValueRange;

  @Override
  public String toString() {
    return "PublicationInfo{"
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
    if (!(o instanceof PublicationInfo)) {
      return false;
    }
    PublicationInfo that = (PublicationInfo) o;
    return Objects.equals(publishers, that.publishers)
        && Objects.equals(datePresentation, that.datePresentation)
        && Objects.equals(dateRange, that.dateRange)
        && Objects.equals(timeValueRange, that.timeValueRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publishers, datePresentation, dateRange, timeValueRange);
  }

  public abstract static class PublicationInfoBuilder<
      C extends PublicationInfo, B extends PublicationInfoBuilder<C, B>> {

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
