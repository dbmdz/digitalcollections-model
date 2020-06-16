package de.digitalcollections.model.api.view;

import de.digitalcollections.model.api.identifiable.Node;
import java.util.List;

/**
 * The breadcrumb navigation.
 *
 * <p>It consists of an ordered list of location items, where the first one is the root location and
 * the last one is the curret location.
 */
public interface BreadcrumbNavigation {

  /**
   * An ordered list of Nodes, each of them represents one location item
   *
   * @return ordered list, the first item is the root location
   */
  List<Node> getLocationItems();
}
