package de.digitalcollections.model.api.view;

import java.util.List;

public interface FacetList {

  String getTitle();

  void setTitle(String title);

  List<SelectedFacetItem> getItems();

  void setFacetItems(List<SelectedFacetItem> items);

  void addFacetItem(SelectedFacetItem item);

}
