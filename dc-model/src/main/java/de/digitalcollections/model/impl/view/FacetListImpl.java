package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.view.FacetList;
import de.digitalcollections.model.api.view.SelectedFacetItem;
import java.util.LinkedList;
import java.util.List;

public class FacetListImpl implements FacetList {

  String title;
  List<SelectedFacetItem> items = new LinkedList<>();

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public List<SelectedFacetItem> getItems() {
    return items;
  }

  @Override
  public void setFacetItems(List<SelectedFacetItem> items) {
    if (items != null) {
      this.items = items;
    }
  }

  @Override
  public void addFacetItem(SelectedFacetItem item) {
    items.add(item);
  }

  @Override
  public String toString() {
    return "FacetListImpl{"
        + "title='" + title + '\''
        + ", items=" + items
        + '}';
  }
}
