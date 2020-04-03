package de.digitalcollections.model.impl.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.parts.Subtopic;
import de.digitalcollections.model.api.identifiable.entity.parts.enums.EntityPartType;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class SubtopicImpl extends EntityPartImpl implements Subtopic {

  private final NodeImpl<Subtopic> node;
  private List<Entity> entites;
  private List<FileResource> fileResources;

  public SubtopicImpl() {
    super();
    this.node = new NodeImpl<>();
    this.entityPartType = EntityPartType.SUBTOPIC;
  }

  @Override
  public List<Subtopic> getChildren() {
    return node.getChildren();
  }

  @Override
  public void setChildren(List<Subtopic> children) {
    node.setChildren(children);
  }

  @Override
  public Subtopic getParent() {
    return node.getParent();
  }

  @Override
  public void setParent(Subtopic parent) {
    node.setParent(parent);
  }

  @Override
  public List<Entity> getEntities() {
    return entites;
  }

  @Override
  public void setEntities(List<Entity> entities) {
    this.entites = entities;
  }

  @Override
  public List<FileResource> getFileResources() {
    return fileResources;
  }

  @Override
  public void setFileResources(List<FileResource> fileResources) {
    this.fileResources = fileResources;
  }
}
