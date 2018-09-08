package de.digitalcollections.model.impl.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.entity.parts.ContentNode;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class ContentNodeImpl extends IdentifiableImpl implements ContentNode<ContentNode> {

  private final NodeImpl<ContentNode> node;

  public ContentNodeImpl() {
    super();
    this.node = new NodeImpl<>();
    this.type = IdentifiableType.ENTITY_PART;
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
  public List<Identifiable> getContent() {
    return node.getContent();
  }

  @Override
  public void setContent(List<Identifiable> content) {
    node.setContent(content);
  }

  @Override
  public ContentNode getParent() {
    return node.getParent();
  }

  @Override
  public void setParent(ContentNode parent) {
    node.setParent(parent);
  }
}
