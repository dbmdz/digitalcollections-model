package de.digitalcollections.model.identifiable.entity;

public class ProjectBuilder extends EntityBuilder<Project, ProjectBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.PROJECT;
  }
}
