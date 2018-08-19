package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.resource.ContentNode;
import de.digitalcollections.model.api.identifiable.resource.ResourceType;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class ContentNodeImpl extends ResourceImpl implements ContentNode<ContentNode> {

  private final NodeImpl<ContentNode> node;

  public ContentNodeImpl() {
    super();
    this.resourceType = ResourceType.CONTENT_NODE;
    this.node = new NodeImpl<>();
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
