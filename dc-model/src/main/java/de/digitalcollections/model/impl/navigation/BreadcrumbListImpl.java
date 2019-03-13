package de.digitalcollections.model.impl.navigation;

import de.digitalcollections.model.api.navigation.BreadcrumbList;
import de.digitalcollections.model.api.navigation.ListItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BreadcrumbListImpl implements BreadcrumbList {

  List<ListItem> itemListElement = new ArrayList<>();

  public BreadcrumbListImpl() {
  }

  public BreadcrumbListImpl(List<ListItem> itemListElement) {
    this.itemListElement = itemListElement;
    Collections.sort(this.itemListElement, Comparator.comparingInt(ListItem::getPosition));
  }

  @Override
  public String getContext() {
    return "https://schema.org";
  }

  @Override
  public String getType() {
    return "BreadcrumbList";
  }

  @Override
  public List<ListItem> getItemListElement() {
    return itemListElement;
  }

  @Override
  public void setItemListElement(List<ListItem> itemListElement) {
    this.itemListElement = itemListElement;
    Collections.sort(this.itemListElement, Comparator.comparingInt(ListItem::getPosition));
  }

  @Override
  public void addListItem(ListItem listItem) {
    this.itemListElement.add(listItem);
    Collections.sort(this.itemListElement, Comparator.comparingInt(ListItem::getPosition));
  }
}
