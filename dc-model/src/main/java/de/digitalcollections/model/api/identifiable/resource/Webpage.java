package de.digitalcollections.model.api.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;

/**
 * A Webpage.
 * @param <W> a webpage instance
 */
public interface Webpage<W extends Webpage> extends Resource, Node<W> {

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);
}
