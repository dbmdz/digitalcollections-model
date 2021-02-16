package de.digitalcollections.model.filter;

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

  public String toString() {
    return "FacetList{" + "title='" + title + '\'' + ", items=" + items + '}';
  }
}
