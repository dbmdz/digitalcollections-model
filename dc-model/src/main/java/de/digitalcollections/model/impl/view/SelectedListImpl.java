package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.view.SelectedList;
import de.digitalcollections.model.api.view.SelectedListItem;
import java.util.LinkedList;
import java.util.List;

public class SelectedListImpl implements SelectedList {

  String title;
  SelectedListItem selectedItem;
  List<SelectedListItem> items = new LinkedList<>();

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public SelectedListItem getSelectedItem() {
    return selectedItem;
  }

  @Override
  public void setSelectedItem(SelectedListItem selectedItem) {
    this.selectedItem = selectedItem;
  }

  @Override
  public List<SelectedListItem> getItems() {
    return items;
  }

  @Override
  public void setItems(List<SelectedListItem> items) {
    if (items != null) {
      this.items = items;
    }
  }

  @Override
  public void addItem(SelectedListItem item) {
    items.add(item);
  }

  @Override
  public String toString() {
    return "SelectedListImpl{"
        + "title='" + title + '\''
        + ", selectedItem=" + selectedItem
        + ", items=" + items
        + '}';
  }
}
