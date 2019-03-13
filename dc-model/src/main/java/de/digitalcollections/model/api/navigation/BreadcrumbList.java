package de.digitalcollections.model.api.navigation;

import java.util.List;

public interface BreadcrumbList {

  String getContext();

  String getType();

  List<ListItem> getItemListElement();

  void setItemListElement(List<ListItem> itemListElement);

  void addListItem(ListItem listItem);
}
