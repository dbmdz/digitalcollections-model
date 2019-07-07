package de.digitalcollections.model.impl.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.parts.ContentNode;
import de.digitalcollections.model.api.identifiable.entity.parts.enums.EntityPartType;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.LinkedHashSet;
import java.util.List;

public class ContentNodeImpl extends EntityPartImpl implements ContentNode<ContentNode> {

  private final NodeImpl<ContentNode> node;
  private LinkedHashSet<Entity> entites;
  private LinkedHashSet<FileResource> fileResources;

  public ContentNodeImpl() {
    super();
    this.node = new NodeImpl<>();
    this.entityPartType = EntityPartType.CONTENT_NODE;
  }

  @Override
  public List<ContentNode> getChildren() {
    return node.getChildren();
  }

  @Override
  public void setChildren(List<ContentNode> children) {
    node.setChildren(children);
  }

  @Override
  public ContentNode getParent() {
    return node.getParent();
  }

  @Override
  public void setParent(ContentNode parent) {
    node.setParent(parent);
  }

  @Override
  public LinkedHashSet<Entity> getEntities() {
    return entites;
  }

  @Override
  public void setEntities(LinkedHashSet<Entity> entities) {
    this.entites = entities;
  }

  @Override
  public LinkedHashSet<FileResource> getFileResources() {
    return fileResources;
  }

  @Override
  public void setFileResources(LinkedHashSet<FileResource> fileResources) {
    this.fileResources = fileResources;
  }
}
