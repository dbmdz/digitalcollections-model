package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.resource.ResourceType;
import de.digitalcollections.model.api.identifiable.resource.Webpage;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class WebpageImpl extends ResourceImpl implements Webpage<Webpage> {

  private final NodeImpl<Webpage> node;
  private LocalizedStructuredContent text;

  public WebpageImpl() {
    super();
    this.node = new NodeImpl<>();
    this.resourceType = ResourceType.WEBPAGE;
  }

  public WebpageImpl(List<Webpage> children) {
    super();
    this.resourceType = ResourceType.WEBPAGE;
    this.node = new NodeImpl<>();
    this.node.setChildren(children);
  }

  @Override
  public List<Webpage> getChildren() {
    return node.getChildren();
  }

  @Override
  public void setChildren(List<Webpage> children) {
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
  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }

  @Override
  public Webpage getParent() {
    return node.getParent();
  }

  @Override
  public void setParent(Webpage parent) {
    node.setParent(parent);
  }
}
