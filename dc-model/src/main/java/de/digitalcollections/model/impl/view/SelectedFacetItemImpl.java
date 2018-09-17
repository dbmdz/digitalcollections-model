package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.view.SelectedFacetItem;

public class SelectedFacetItemImpl implements SelectedFacetItem {

  String name;
  long count;
  String link;
  boolean selected;

  public SelectedFacetItemImpl(String name, Long count) {
    this.name = name;
    this.count = count;
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
  public long getCount() {
    return count;
  }

  @Override
  public void setCount(long count) {
    this.count = count;
  }

  @Override
  public String getLink() {
    return link;
  }

  @Override
  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public boolean isSelected() {
    return selected;
  }

  @Override
  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  @Override
  public String toString() {
    return "SelectedFacetItemImpl{"
        + "name='" + name + '\''
        + ", count=" + count
        + ", link='" + link + '\''
        + ", selected=" + selected
        + '}';
  }
}
