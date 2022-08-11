package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;

/** An involvement role defines how an agent is involved related to a work. */
public class InvolvementRole {

  private LocalizedText label;
  private String name;

  public InvolvementRole() {}

  public InvolvementRole(LocalizedText label, String name) {
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
