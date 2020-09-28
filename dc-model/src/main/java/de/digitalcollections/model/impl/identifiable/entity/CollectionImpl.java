package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.entity.Collection;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.time.LocalDate;
import java.util.List;

public class CollectionImpl extends EntityImpl implements Collection {

  private List<Entity> entities;
  private final Node<Collection> node;
  private LocalDate publicationEnd;
  private LocalDate publicationStart;
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
  public LocalDate getPublicationEnd() {
    return publicationEnd;
  }

  @Override
  public void setPublicationEnd(LocalDate publicationEnd) {
    this.publicationEnd = publicationEnd;
  }

  @Override
  public LocalDate getPublicationStart() {
    return publicationStart;
  }

  @Override
  public void setPublicationStart(LocalDate publicationStart) {
    this.publicationStart = publicationStart;
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
