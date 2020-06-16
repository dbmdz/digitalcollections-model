package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.view.BreadcrumbNavigation;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.ArrayList;
import java.util.List;

public class BreadcrumbNavigationImpl implements BreadcrumbNavigation {

  private List<Node> locationItems = new ArrayList<>();

  public BreadcrumbNavigationImpl() {}

  public BreadcrumbNavigationImpl(List<Node> locationItems) {
    this.locationItems = locationItems;
  }

  @Override
  public List<Node> getLocationItems() {
    return locationItems;
  }
}
