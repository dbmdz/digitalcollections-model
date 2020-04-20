package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDate;

/** A Webpage of a Website. */
public interface Webpage extends Node<Webpage>, EntityPart {

  LocalDate getPublicationEnd();

  void setPublicationEnd(LocalDate publicationEnd);

  LocalDate getPublicationStart();

  void setPublicationStart(LocalDate publicationStart);

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);
}
