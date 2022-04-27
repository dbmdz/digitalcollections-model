package de.digitalcollections.model.view;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import java.util.UUID;

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private RenderingTemplate renderingTemplate = new RenderingTemplate();

    public RenderingTemplate build() {
      return renderingTemplate;
    }

    public Builder withName(String name) {
      renderingTemplate.setName(name);
      return this;
    }

    public Builder withUuid(String uuid) {
      renderingTemplate.setUuid(UUID.fromString(uuid));
      return this;
    }

    public Builder withDescription(Locale locale, String text) {
      LocalizedText description = renderingTemplate.getDescription();
      if (description == null) {
        description = new LocalizedText();
      }
      description.setText(locale, text);
      renderingTemplate.setDescription(description);
      return this;
    }

    public Builder withLabel(Locale locale, String localizedLabel) {
      LocalizedText label = renderingTemplate.getLabel();
      if (label == null) {
        label = new LocalizedText();
      }
      label.setText(locale, localizedLabel);
      renderingTemplate.setLabel(label);
      return this;
    }
  }
}
