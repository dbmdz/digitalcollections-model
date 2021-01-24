package de.digitalcollections.model.api.identifiable.entity.relation;

import de.digitalcollections.model.api.identifiable.entity.Entity;

public interface EntityRelation {

  Entity getSubject();

  String getPredicate();

  Entity getObject();

  void setSubject(Entity subjectEntity);

  void setPredicate(String predicate);

  void setObject(Entity objectEntity);
}
