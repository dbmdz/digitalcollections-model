package de.digitalcollections.model.api.view;

import java.util.List;

/**
 * A List with a title, a list of selectable items and one dedicated item, which is selected.
 */
public interface SelectedList {

  String getTitle();

  void setTitle(String title);

  SelectedListItem getSelectedItem();

  void setSelectedItem(SelectedListItem selectedItem);

  List<SelectedListItem> getItems();

  void setItems(List<SelectedListItem> items);

  void addItem(SelectedListItem item);

}
