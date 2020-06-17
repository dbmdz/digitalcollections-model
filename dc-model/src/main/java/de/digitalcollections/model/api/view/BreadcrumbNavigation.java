package de.digitalcollections.model.api.view;

import de.digitalcollections.model.api.identifiable.Node;
import java.util.List;

/**
 * The breadcrumb navigation.
 *
 * <p>It consists of an ordered list of Nodes, representing navigation items, where the first one is
 * the root item, the webpage (hence no uuid), and the last one is the navigation item for the
 * current location.
 */
public interface BreadcrumbNavigation {

  /**
   * An ordered list of Nodes, each of them represents one navigation item with a label and an uuid
   *
   * @return ordered list, the first item is the root location
   */
  List<Node> getNavigationItems();
}
