package de.digitalcollections.model.impl.navigation;

import de.digitalcollections.model.api.navigation.ListItem;

public class ListItemImpl implements ListItem {

  int position = 0;
  String name = null;
  String item = null;

  public ListItemImpl() {
  }

  public ListItemImpl(int position, String name, String item) {
    this.position = position;
    this.name = name;
    this.item = item;
  }

  @Override
  public String getType() {
    return "ListItem";
  }

  @Override
  public int getPosition() {
    return position;
  }

  @Override
  public void setPosition(int position) {
    this.position = position;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getItem() {
    return item;
  }

  @Override
  public void setItem(String item) {
    this.item = item;
  }
}
