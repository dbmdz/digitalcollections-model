package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.EntityRelation;

public class EntityRelationImpl implements EntityRelation<Entity> {

  private Entity object;
  private String predicate;
  private Entity subject;

  public EntityRelationImpl() {

  }

  public EntityRelationImpl(Entity subject, String predicate, Entity object) {
    this.subject = subject;
    this.predicate = predicate;
    this.object = object;
  }

  @Override
  public Entity getObject() {
    return object;
  }

  @Override
  public void setObject(Entity objectEntity) {
    this.object = objectEntity;
  }

  @Override
  public String getPredicate() {
    return predicate;
  }

  @Override
  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }

  @Override
  public Entity getSubject() {
    return subject;
  }

  @Override
  public void setSubject(Entity subjectEntity) {
    this.subject = subjectEntity;
  }

}
