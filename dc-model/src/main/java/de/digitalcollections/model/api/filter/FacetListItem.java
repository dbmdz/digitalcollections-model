package de.digitalcollections.model.api.filter;

/** A facet value of a specific facet, e.g. value "image" of facet "mediatype" */
public interface FacetListItem {

  String getName();

  void setName(String name);

  long getCount();

  void setCount(long count);

  String getLink();

  void setLink(String link);

  boolean isSelected();

  void setSelected(boolean selected);
}
