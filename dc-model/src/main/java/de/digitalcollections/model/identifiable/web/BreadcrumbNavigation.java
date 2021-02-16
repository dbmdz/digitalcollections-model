package de.digitalcollections.model.identifiable.web;

import de.digitalcollections.model.identifiable.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * The breadcrumb navigation.
 *
 * <p>It consists of an ordered list of Nodes, representing navigation items, where the first one is
 * the root item, the webpage (hence no uuid), and the last one is the navigation item for the
 * current location.
 */
public class BreadcrumbNavigation {

  private List<Node> navigationItems = new ArrayList<>();

  public BreadcrumbNavigation() {}

  public BreadcrumbNavigation(List<Node> navigationItems) {
    this.navigationItems = navigationItems;
  }

  /**
   * An ordered list of Nodes, each of them represents one navigation item with a label and an uuid
   *
   * @return ordered list, the first item is the root location
   */
  public List<Node> getNavigationItems() {
    return navigationItems;
  }
}
