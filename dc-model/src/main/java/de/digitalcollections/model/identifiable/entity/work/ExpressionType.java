package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class ExpressionType {

  private LocalizedText label;
  private String mainType;
  private String subType;

  public ExpressionType() {
    init();
  }

  public ExpressionType(LocalizedText label, String mainType, String subType) {
    this();
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

  protected void init() {}

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setMainType(String mainType) {
    this.mainType = mainType;
  }

  public void setSubType(String subType) {
    this.subType = subType;
  }

  public abstract static class ExpressionTypeBuilder<
      C extends ExpressionType, B extends ExpressionTypeBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
