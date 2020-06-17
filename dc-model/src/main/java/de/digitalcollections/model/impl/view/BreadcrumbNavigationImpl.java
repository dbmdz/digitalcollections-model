package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.view.BreadcrumbNavigation;
import java.util.ArrayList;
import java.util.List;

public class BreadcrumbNavigationImpl implements BreadcrumbNavigation {

  private List<Node> navigationItems = new ArrayList<>();

  public BreadcrumbNavigationImpl() {}

  public BreadcrumbNavigationImpl(List<Node> navigationItems) {
    this.navigationItems = navigationItems;
  }

  @Override
  public List<Node> getNavigationItems() {
    return navigationItems;
  }
}
