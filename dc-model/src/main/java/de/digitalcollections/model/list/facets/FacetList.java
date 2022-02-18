package de.digitalcollections.model.list.facets;

import java.util.LinkedList;
import java.util.List;

public class FacetList {

  List<FacetListItem> items = new LinkedList<>();
  String title;

  public void addItem(FacetListItem item) {
    items.add(item);
  }

  public List<FacetListItem> getItems() {
    return items;
  }

  public String getTitle() {
    return title;
  }

  public void setItems(List<FacetListItem> items) {
    if (items != null) {
      this.items = items;
    }
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{title='" + title + "', items=" + items + "}";
  }
}
