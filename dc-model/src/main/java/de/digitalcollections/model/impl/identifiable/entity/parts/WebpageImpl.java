package de.digitalcollections.model.impl.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.IdentifiablesContainer;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;
import de.digitalcollections.model.impl.identifiable.IdentifiablesContainerImpl;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class WebpageImpl extends IdentifiableImpl implements Webpage<Webpage> {

  private final IdentifiablesContainer identifiablesContainer = new IdentifiablesContainerImpl();
  private final NodeImpl<Webpage> node = new NodeImpl<>();
  private LocalizedStructuredContent text;

  public WebpageImpl() {
    super();
    this.type = IdentifiableType.ENTITY_PART;
  }

  public WebpageImpl(List<Webpage> children) {
    this();
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
  public List<Identifiable> getIdentifiables() {
    return identifiablesContainer.getIdentifiables();
  }

  @Override
  public void setIdentifiables(List<Identifiable> identifiables) {
    identifiablesContainer.setIdentifiables(identifiables);
  }
}
