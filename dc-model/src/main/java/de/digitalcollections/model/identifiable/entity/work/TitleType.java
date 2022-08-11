package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;

public class TitleType {

  private LocalizedText label;
  private String mainType;
  private String subType;

  public TitleType() {}

  public TitleType(LocalizedText label, String mainType, String subType) {
    this.label = label;
    this.mainType = mainType;
    this.subType = subType;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public String getMainType() {
    return mainType;
  }

  public String getSubType() {
    return subType;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setMainType(String mainType) {
    this.mainType = mainType;
  }

  public void setSubType(String subType) {
    this.subType = subType;
  }
}
