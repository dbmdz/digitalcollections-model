package de.digitalcollections.model.identifiable.web;

import de.digitalcollections.model.identifiable.INode;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.Node;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.view.RenderingHints;
import de.digitalcollections.model.view.RenderingHintsPreviewImage;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends Identifiable.Builder<Webpage, Builder> {

    @Override
    protected IdentifiableType getIdentifiableType() {
      return IdentifiableType.RESOURCE;
    }

    public Builder setIdentifiers(Set<Identifier> identifiers) {
      identifiable.setIdentifiers(identifiers);
      return this;
    }

    public Builder withPublicationStartAt(String publicationStart) {
      identifiable.setPublicationStart(LocalDate.parse(publicationStart));
      return this;
    }

    public Builder shownInNavigation() {
      RenderingHints renderingHints = new RenderingHints();
      renderingHints.setShowInPageNavigation(true);
      identifiable.setRenderingHints(renderingHints);
      return this;
    }

    public Builder notShownInNavigation() {
      RenderingHints renderingHints = new RenderingHints();
      renderingHints.setShowInPageNavigation(false);
      identifiable.setRenderingHints(renderingHints);
      return this;
    }

    public Builder withOpenLinkInNewWindow() {
      RenderingHintsPreviewImage previewImageRenderingHints =
          identifiable.getPreviewImageRenderingHints();
      if (previewImageRenderingHints == null) {
        previewImageRenderingHints = new RenderingHintsPreviewImage();
      }
      previewImageRenderingHints.setOpenLinkInNewWindow(true);
      identifiable.setPreviewImageRenderingHints(previewImageRenderingHints);
      return this;
    }

    public Builder withTemplateName(String templateName) {
      RenderingHints renderingHints = identifiable.getRenderingHints();
      if (renderingHints == null) {
        renderingHints = new RenderingHints();
      }
      renderingHints.setTemplateName(templateName);
      identifiable.setRenderingHints(renderingHints);
      return this;
    }

    public Builder withChildren(List<Webpage> children) {
      identifiable.setChildren(children);
      return this;
    }
  }
}
