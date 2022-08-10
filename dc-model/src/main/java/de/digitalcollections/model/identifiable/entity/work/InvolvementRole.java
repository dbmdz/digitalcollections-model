package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;

/** An involvement role defines how an agent is involved related to a work. */
public class InvolvementRole {

  private LocalizedText label;
  private String shortcut;

  public LocalizedText getLabel() {
    return label;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public String getShortcut() {
    return shortcut;
  }

  public void setShortcut(String shortcut) {
    this.shortcut = shortcut;
  }
}
