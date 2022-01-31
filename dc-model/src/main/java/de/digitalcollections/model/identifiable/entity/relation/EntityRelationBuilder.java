package de.digitalcollections.model.identifiable.entity.relation;

import de.digitalcollections.model.identifiable.entity.Entity;

public class EntityRelationBuilder {

  EntityRelation entityRelation = new EntityRelation();

  public EntityRelation build() {
    return entityRelation;
  }

  public EntityRelationBuilder withPredicate(String predicate) {
    entityRelation.setPredicate(predicate);
    return this;
  }

  public EntityRelationBuilder withSubject(Entity subjectEntity) {
    entityRelation.setSubject(subjectEntity);
    return this;
  }

  public EntityRelationBuilder withObject(Entity objectEntity) {
    entityRelation.setObject(objectEntity);
    return this;
  }
}
