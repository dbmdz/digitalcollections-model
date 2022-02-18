package de.digitalcollections.model.list.facets;

/** A facet value of a specific facet, e.g. value "image" of facet "mediatype" */
public class FacetListItem {

  long count;
  String link;
  String name;
  boolean selected;

  public FacetListItem(String name, Long count) {
    this.name = name;
    this.count = count;
  }

  public long getCount() {
    return count;
  }

  public String getLink() {
    return link;
  }

  public String getName() {
    return name;
  }

  public boolean isSelected() {
    return selected;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
        + "{name='"
        + name
        + "', count="
        + count
        + ", link='"
        + link
        + "', selected="
        + selected
        + "}";
  }
}
