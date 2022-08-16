package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class ManufacturingType {

  private LocalizedText label;
  private String name;

  public ManufacturingType() {
    init();
  }

  public ManufacturingType(LocalizedText label, String name) {
    this();
    this.label = label;
    this.name = name;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public String getName() {
    return name;
  }

  protected void init() {}

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setName(String name) {
    this.name = name;
  }

  public abstract static class ManufacturingTypeBuilder<
      C extends ManufacturingType, B extends ManufacturingTypeBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
