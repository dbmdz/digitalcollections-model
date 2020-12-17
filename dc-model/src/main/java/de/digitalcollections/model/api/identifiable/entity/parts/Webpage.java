package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.view.RenderingHints;
import java.time.LocalDate;

/** A Webpage of a Website. */
public interface Webpage extends Node<Webpage>, EntityPart {

  LocalDate getPublicationEnd();

  void setPublicationEnd(LocalDate publicationEnd);

  LocalDate getPublicationStart();

  void setPublicationStart(LocalDate publicationStart);

  RenderingHints getRenderingHints();

  void setRenderingHints(RenderingHints renderingHints);

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);
}
