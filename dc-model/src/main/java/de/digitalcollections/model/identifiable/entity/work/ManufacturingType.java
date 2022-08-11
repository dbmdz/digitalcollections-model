package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;

public class ManufacturingType {

  private LocalizedText label;
  private String name;

  public ManufacturingType() {}

  public ManufacturingType(LocalizedText label, String name) {
    this.label = label;
    this.name = name;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public String getName() {
    return name;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setName(String name) {
    this.name = name;
  }
}
