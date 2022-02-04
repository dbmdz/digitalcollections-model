package de.digitalcollections.model.view;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.text.LocalizedText;

/**
 * Defines a rendering template to be used in the system implementing this library. It is up to the
 * implementor to add all relevant rendering templates to his system. Each RenderingTemplate can be
 * described by a label, a description and a name.
 */
public class RenderingTemplate extends UniqueObject {

  private LocalizedText description;
  private LocalizedText label;
  private String name;

  public LocalizedText getDescription() {
    return description;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public String getName() {
    return name;
  }

  public void setDescription(LocalizedText description) {
    this.description = description;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setName(String name) {
    this.name = name;
  }
}
