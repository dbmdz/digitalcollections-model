package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.entity.Collection;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class CollectionImpl extends EntityImpl implements Collection {

  private List<Entity> entities;
  private final Node<Collection> node;
  private LocalizedStructuredContent text;

  public CollectionImpl() {
    super();
    this.entityType = EntityType.COLLECTION;
    this.node = new NodeImpl<>();
  }

  @Override
  public List<Collection> getChildren() {
    return node.getChildren();
  }

  @Override
  public void setChildren(List<Collection> children) {
    node.setChildren(children);
  }

  @Override
  public List<Entity> getEntities() {
    return entities;
  }

  @Override
  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  @Override
  public Collection getParent() {
    return node.getParent();
  }

  @Override
  public void setParent(Collection parent) {
    node.setParent(parent);
  }

  @Override
  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }
}
