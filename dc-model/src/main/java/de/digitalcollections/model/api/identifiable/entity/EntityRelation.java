package de.digitalcollections.model.api.identifiable.entity;

public interface EntityRelation<E extends Entity> {

  E getSubject();

  String getPredicate();

  E getObject();

  void setSubject(E subjectEntity);

  void setPredicate(String predicate);

  void setObject(E objectEntity);
}
