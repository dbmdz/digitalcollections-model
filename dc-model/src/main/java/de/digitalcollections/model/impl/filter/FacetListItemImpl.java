package de.digitalcollections.model.impl.filter;

import de.digitalcollections.model.api.filter.FacetListItem;

public class FacetListItemImpl implements FacetListItem {

  String name;
  long count;
  String link;
  boolean selected;

  public FacetListItemImpl(String name, Long count) {
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
    return "FacetListItemImpl{"
            + "name='" + name + '\''
            + ", count=" + count
            + ", link='" + link + '\''
            + ", selected=" + selected
            + '}';
  }
}
