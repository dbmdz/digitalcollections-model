package de.digitalcollections.model.identifiable.web;

import de.digitalcollections.model.identifiable.INode;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.Node;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.view.RenderingHints;
import java.time.LocalDate;
import java.util.List;
import lombok.experimental.SuperBuilder;

/** A Webpage of a Website. */
@SuperBuilder(buildMethodName = "prebuild")
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

  @Override
  public List<Webpage> getChildren() {
    return node.getChildren();
  }

  @Override
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

  @Override
  public void setChildren(List<Webpage> children) {
    node.setChildren(children);
  }

  @Override
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

  public abstract static class WebpageBuilder<C extends Webpage, B extends WebpageBuilder<C, B>>
      extends IdentifiableBuilder<C, B> {

    private List<Webpage> children;

    public B publicationStart(String publicationStart) {
      this.publicationStart = LocalDate.parse(publicationStart);
      return self();
    }

    public B publicationEnd(String publicationEnd) {
      this.publicationEnd = LocalDate.parse(publicationEnd);
      return self();
    }

    public B shownInNavigation() {
      if (renderingHints == null) {
        renderingHints = new RenderingHints();
      }
      renderingHints.setShowInPageNavigation(true);
      return self();
    }

    public B notShownInNavigation() {
      if (renderingHints == null) {
        renderingHints = new RenderingHints();
      }
      renderingHints.setShowInPageNavigation(false);
      return self();
    }

    public B children(List<Webpage> children) {
      this.children = children;
      return self();
    }

    public B templateName(String templateName) {
      if (renderingHints == null) {
        renderingHints = new RenderingHints();
      }
      renderingHints.setTemplateName(templateName);
      return self();
    }

    @Override
    public C build() {
      C c = prebuild();
      c.setType(IdentifiableType.RESOURCE);
      c.setChildren(children);
      setInternalReferences(c);
      return c;
    }
  }
}
