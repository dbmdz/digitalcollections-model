package de.digitalcollections.model.identifiable.entity.relation;

import de.digitalcollections.model.identifiable.entity.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An EntityRelation describes the relation between two entities (subject being related to object in
 * terms of predicate)
 */
public class EntityRelation {

  public static Builder builder() {
    return new Builder();
  }

  private Entity object;
  private String predicate;
  private Entity subject;

  private List<String> additionalPredicates;

  public EntityRelation() {}

  public EntityRelation(Entity subject, String predicate, Entity object) {
    this.subject = subject;
    this.predicate = predicate;
    this.object = object;
  }

  public Entity getObject() {
    return object;
  }

  public String getPredicate() {
    return predicate;
  }

  public Entity getSubject() {
    return subject;
  }

  public void setObject(Entity objectEntity) {
    this.object = objectEntity;
  }

  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }

  public void setSubject(Entity subjectEntity) {
    this.subject = subjectEntity;
  }

  public List<String> getAdditionalPredicates() {
    return additionalPredicates;
  }

  public void setAdditionalPredicates(List<String> additionalPredicates) {
    this.additionalPredicates = additionalPredicates;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EntityRelation)) {
      return false;
    }
    EntityRelation that = (EntityRelation) o;
    return Objects.equals(object, that.object)
        && Objects.equals(predicate, that.predicate)
        && Objects.equals(subject, that.subject)
        && Objects.equals(additionalPredicates, that.additionalPredicates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(object, predicate, subject);
  }

  @Override
  public String toString() {
    return "EntityRelation{"
        + "object="
        + object
        + ", predicate='"
        + predicate
        + '\''
        + ", subject="
        + subject
        + ", additionalPredicates="
        + additionalPredicates
        + '}';
  }

  public static class Builder {

    EntityRelation entityRelation = new EntityRelation();

    public EntityRelation build() {
      return entityRelation;
    }

    public Builder object(Entity objectEntity) {
      entityRelation.setObject(objectEntity);
      return this;
    }

    public Builder predicate(String predicate) {
      entityRelation.setPredicate(predicate);
      return this;
    }

    public Builder subject(Entity subjectEntity) {
      entityRelation.setSubject(subjectEntity);
      return this;
    }

    public Builder additionalPredicate(String additionalPredicate) {
      if (entityRelation.additionalPredicates == null) {
        entityRelation.additionalPredicates = new ArrayList<>(1);
      }
      entityRelation.additionalPredicates.add(additionalPredicate);
      return this;
    }

    public Builder additionalPredicates(List<String> additionalPredicates) {
      entityRelation.setAdditionalPredicates(additionalPredicates);
      return this;
    }
  }
}
