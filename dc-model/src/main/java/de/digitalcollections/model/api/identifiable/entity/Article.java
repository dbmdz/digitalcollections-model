package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;

/**
 * Article is used to manage cultural articles and their hierarchy.
 * @param <A> an article instance
 */
public interface Article<A extends Article> extends Entity, Node<A> {

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);
}
