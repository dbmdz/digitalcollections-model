package de.digitalcollections.model.identifiable.entity.relation;

import de.digitalcollections.model.identifiable.entity.Entity;

/**
 * An EntityRelation describes the relation between two entities (subject being related to object in
 * terms of predicate)
 */
public class EntityRelation {

  private Entity object;
  private String predicate;
  private Entity subject;

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
}
