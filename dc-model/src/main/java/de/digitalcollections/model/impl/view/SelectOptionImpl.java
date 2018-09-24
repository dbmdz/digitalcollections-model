package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.view.SelectOption;

public class SelectOptionImpl implements SelectOption {

  String id;
  String title;
  String subTitle;
  String link;
  boolean selected;

  public SelectOptionImpl(String id, String title) {
    this.id = id;
    this.title = title;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String getSubTitle() {
    return subTitle;
  }

  @Override
  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
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
    return "SelectOptionImpl{"
            + "id='" + id + '\''
            + ", title='" + title + '\''
            + ", subTitle='" + subTitle + '\''
            + ", link='" + link + '\''
            + ", selected=" + selected
            + '}';
  }
}
