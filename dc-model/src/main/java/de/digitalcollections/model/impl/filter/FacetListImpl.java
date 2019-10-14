package de.digitalcollections.model.impl.filter;

import de.digitalcollections.model.api.filter.FacetList;
import de.digitalcollections.model.api.filter.FacetListItem;
import java.util.LinkedList;
import java.util.List;

public class FacetListImpl implements FacetList {

  String title;
  List<FacetListItem> items = new LinkedList<>();

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public List<FacetListItem> getItems() {
    return items;
  }

  @Override
  public void setItems(List<FacetListItem> items) {
    if (items != null) {
      this.items = items;
    }
  }

  @Override
  public void addItem(FacetListItem item) {
    items.add(item);
  }

  @Override
  public String toString() {
    return "FacetListImpl{" + "title='" + title + '\'' + ", items=" + items + '}';
  }
}
