package de.digitalcollections.model.api.navigation;

public interface ListItem {

  String getType();

  int getPosition();

  void setPosition(int position);

  String getName();

  void setName(String name);

  String getItem();

  void setItem(String item);

}
