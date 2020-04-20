package de.digitalcollections.model.impl.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.identifiable.entity.parts.enums.EntityPartType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.time.LocalDate;
import java.util.List;

public class WebpageImpl extends EntityPartImpl implements Webpage {

  private final NodeImpl<Webpage> node = new NodeImpl<>();
  private LocalizedStructuredContent text;
  private LocalDate publicationEnd;
  private LocalDate publicationStart;

  public WebpageImpl() {
    super();
    this.entityPartType = EntityPartType.WEBPAGE;
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
}
