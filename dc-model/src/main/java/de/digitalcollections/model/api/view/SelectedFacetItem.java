package de.digitalcollections.model.api.view;

public interface SelectedFacetItem {

  String getName();

  void setName(String name);

  long getCount();

  void setCount(long count);

  String getLink();

  void setLink(String link);

  boolean isSelected();

  void setSelected(boolean selected);

}
