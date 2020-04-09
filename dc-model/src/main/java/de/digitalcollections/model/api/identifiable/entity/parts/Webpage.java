package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDate;

/** A Webpage of a Website. */
public interface Webpage extends Node<Webpage>, EntityPart {

  LocalDate getPublishEnd();

  void setPublishEnd(LocalDate publishEnd);

  LocalDate getPublishStart();

  void setPublishStart(LocalDate publishStart);

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);
}
