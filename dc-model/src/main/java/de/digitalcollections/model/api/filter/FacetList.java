package de.digitalcollections.model.api.filter;

import java.util.List;

public interface FacetList {

  String getTitle();

  void setTitle(String title);

  List<FacetListItem> getItems();

  void setItems(List<FacetListItem> items);

  void addItem(FacetListItem item);
}
