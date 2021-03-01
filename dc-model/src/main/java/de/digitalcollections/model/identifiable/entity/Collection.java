package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.INode;
import de.digitalcollections.model.identifiable.Node;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** A collection of {@link Entity}s. */
public class Collection extends Entity implements INode<Collection> {

  private List<Entity> entities;
  private final Node<Collection> node = new Node<>();
  private LocalDate publicationEnd;
  private LocalDate publicationStart;
  private LocalizedStructuredContent text;

  public Collection() {
    super();
    this.entityType = EntityType.COLLECTION;
  }

  public void addEntity(Entity entity) {
    if (getEntities() == null) {
      setEntities(new ArrayList<>());
    }
    getEntities().add(entity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Collection)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Collection that = (Collection) o;
    return Objects.equals(entities, that.entities)
        && Objects.equals(node, that.node)
        && Objects.equals(publicationEnd, that.publicationEnd)
        && Objects.equals(publicationStart, that.publicationStart)
        && Objects.equals(text, that.text);
  }

  public List<Collection> getChildren() {
    return node.getChildren();
  }

  public List<Entity> getEntities() {
    return entities;
  }

  public Node<Collection> getNode() {
    return node;
  }

  public Collection getParent() {
    return node.getParent();
  }

  public LocalDate getPublicationEnd() {
    return publicationEnd;
  }

  public LocalDate getPublicationStart() {
    return publicationStart;
  }

  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), entities, node, publicationEnd, publicationStart, text);
  }

  public void setChildren(List<Collection> children) {
    node.setChildren(children);
  }

  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  public void setParent(Collection parent) {
    node.setParent(parent);
  }

  public void setPublicationEnd(LocalDate publicationEnd) {
    this.publicationEnd = publicationEnd;
  }

  public void setPublicationStart(LocalDate publicationStart) {
    this.publicationStart = publicationStart;
  }

  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
        + "{entities="
        + entities
        + ", node="
        + node
        + ", publicationEnd="
        + publicationEnd
        + ", publicationStart="
        + publicationStart
        + ", text="
        + text
        + ", customAttributes="
        + customAttributes
        + ", entityType="
        + entityType
        + ", refId="
        + refId
        + ", created="
        + created
        + ", description="
        + description
        + ", label="
        + label
        + ", lastModified="
        + lastModified
        + ", previewImage="
        + previewImage
        + ", previewImageRenderingHints="
        + previewImageRenderingHints
        + ", type="
        + type
        + ", uuid="
        + getUuid()
        + "}";
  }
}
