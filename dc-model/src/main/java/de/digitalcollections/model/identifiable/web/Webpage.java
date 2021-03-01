package de.digitalcollections.model.identifiable.web;

import de.digitalcollections.model.identifiable.INode;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.Node;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.view.RenderingHints;
import java.time.LocalDate;
import java.util.List;

/** A Webpage of a Website. */
public class Webpage extends Identifiable implements INode<Webpage> {

  private final Node<Webpage> node = new Node<>();
  private LocalDate publicationEnd;
  private LocalDate publicationStart;
  private RenderingHints renderingHints;
  private LocalizedStructuredContent text;

  public Webpage() {
    super();
    this.type = IdentifiableType.RESOURCE;
  }

  public Webpage(List<Webpage> children) {
    this();
    this.node.setChildren(children);
  }

  public List<Webpage> getChildren() {
    return node.getChildren();
  }

  public Webpage getParent() {
    return node.getParent();
  }

  public LocalDate getPublicationEnd() {
    return publicationEnd;
  }

  public LocalDate getPublicationStart() {
    return publicationStart;
  }

  public RenderingHints getRenderingHints() {
    return renderingHints;
  }

  public LocalizedStructuredContent getText() {
    return text;
  }

  public void setChildren(List<Webpage> children) {
    node.setChildren(children);
  }

  public void setParent(Webpage parent) {
    node.setParent(parent);
  }

  public void setPublicationEnd(LocalDate publicationEnd) {
    this.publicationEnd = publicationEnd;
  }

  public void setPublicationStart(LocalDate publicationStart) {
    this.publicationStart = publicationStart;
  }

  public void setRenderingHints(RenderingHints renderingHints) {
    this.renderingHints = renderingHints;
  }

  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }
}
