package de.digitalcollections.model.api.view;

/** A List item with an identifier, a title, a sub title, a link and a flag for being selected */
public interface SelectOption {

  String getId();

  void setId(String id);

  String getTitle();

  void setTitle(String title);

  String getSubTitle();

  void setSubTitle(String subTitle);

  String getLink();

  void setLink(String link);

  boolean isSelected();

  void setSelected(boolean selected);
}
