package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import java.util.UUID;

/**
 * Defines a rendering template to be used in the system implementing this library. It is up to the
 * implementor to add all relevant rendering templates to his system. Each RenderingTemplate can be
 * described by a label, a description and a name.
 */
public class RenderingTemplate {

  private LocalizedText description;
  private LocalizedText label;
  private String name;
  private UUID uuid;

  public LocalizedText getDescription() {
    return description;
  }

  public void setDescription(LocalizedText description) {
    this.description = description;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
