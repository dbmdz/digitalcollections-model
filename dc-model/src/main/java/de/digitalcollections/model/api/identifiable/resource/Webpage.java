package de.digitalcollections.model.api.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.util.List;

/**
 * A Webpage.
 */
public interface Webpage extends Resource, Node<Webpage> {

  List<Webpage> getSubPages();

  void setSubPages(List<Webpage> subPages);

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent localizedStructuredContent);
}
