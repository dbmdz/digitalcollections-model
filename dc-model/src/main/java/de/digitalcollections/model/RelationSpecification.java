package de.digitalcollections.model;

import java.util.Objects;
import lombok.Builder;
import lombok.Value;

/** A decorator for a relation, which adds two fields for a title and a sort key */
@Value
@Builder
public class RelationSpecification<U extends UniqueObject> {

  private String title;

  private String sortKey;
  private U subject;

  public RelationSpecification() {
    title = null;
    sortKey = null;
    subject = null;
  }

  public RelationSpecification(String title, String sortKey, U subject) {
    this.title = title;
    this.sortKey = sortKey;
    this.subject = subject;
  }

  public String getTitle() {
    return title;
  }

  public String getSortKey() {
    return sortKey;
  }

  public U getSubject() {
    return subject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RelationSpecification)) {
      return false;
    }
    RelationSpecification<?> that = (RelationSpecification<?>) o;
    return Objects.equals(title, that.title)
        && Objects.equals(sortKey, that.sortKey)
        && Objects.equals(subject, that.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, sortKey, subject);
  }

  @Override
  public String toString() {
    return "RelationSpecification{"
        + "title='"
        + title
        + '\''
        + ", sortKey='"
        + sortKey
        + '\''
        + ", subject="
        + subject
        + '}';
  }
}
