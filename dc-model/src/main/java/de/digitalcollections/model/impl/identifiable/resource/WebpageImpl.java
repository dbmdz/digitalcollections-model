package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.resource.ResourceType;
import de.digitalcollections.model.api.identifiable.resource.Webpage;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;

public class WebpageImpl extends ResourceImpl implements Webpage, Node<Webpage> {

  private final NodeImpl<Webpage> node;
  private LocalizedStructuredContent text;
  private List<Webpage> subPages;

  public WebpageImpl() {
    super();
    this.node = new NodeImpl<>();
    this.resourceType = ResourceType.WEBPAGE;
  }

  public WebpageImpl(List<Webpage> subPages) {
    super();
    this.node = new NodeImpl<>();
    this.resourceType = ResourceType.WEBPAGE;
    this.subPages = subPages;
  }

  @Override
  public void addChild(Webpage child) {
    node.addChild(child);
  }

  @Override
  public void addContent(Identifiable identifiable) {
    node.addContent(identifiable);
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

  @Override
  public ResourceType getResourceType() {
    return resourceType;
  }

  @Override
  public void setResourceType(ResourceType resourceType) {
    this.resourceType = resourceType;
  }

  @Override
  public List<Webpage> getSubPages() {
    return subPages;
  }

  @Override
  public void setSubPages(List<Webpage> subPages) {
    this.subPages = subPages;
  }
}
