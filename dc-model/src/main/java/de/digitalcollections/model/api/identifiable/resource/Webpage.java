package de.digitalcollections.model.api.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Node;
import java.util.List;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;

/**
 * A Webpage.
 */
public interface Webpage extends Resource, Node<Webpage> {

  List<Webpage> getSubPages();

  void setSubPages(List<Webpage> subPages);

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent multilanguageDocument);
}
