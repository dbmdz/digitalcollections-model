package de.digitalcollections.model.identifiable.entity.manifestation;

import de.digitalcollections.model.time.LocalDateRange;
import de.digitalcollections.model.time.TimeValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class PublishingInfo {

  private List<Publisher> publishers;
  private String datePresentation;
  private LocalDateRange navDateRange; // für Sortierung und Suche, heuristisch befüllt
  private TimeValueRange timeValueRange;

  public PublishingInfo() {}

  public boolean isEmpty() {
    return (publishers == null || publishers.isEmpty())
        && datePresentation == null
        && navDateRange == null
        && timeValueRange == null;
  }

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

  public LocalDateRange getNavDateRange() {
    return navDateRange;
  }

  public void setNavDateRange(LocalDateRange navDateRange) {
    this.navDateRange = navDateRange;
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
        + ", navDateRange="
        + navDateRange
        + ", timeValueRange="
        + timeValueRange
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PublishingInfo)) {
      return false;
    }
    PublishingInfo that = (PublishingInfo) o;
    return Objects.equals(publishers, that.publishers)
        && Objects.equals(datePresentation, that.datePresentation)
        && Objects.equals(navDateRange, that.navDateRange)
        && Objects.equals(timeValueRange, that.timeValueRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publishers, datePresentation, navDateRange, timeValueRange);
  }

  public abstract static class PublishingInfoBuilder<
      C extends PublishingInfo, B extends PublishingInfoBuilder<C, B>> {

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
