package de.digitalcollections.model.identifiable.entity.work;

import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class ExpressionType {

  private String mainType;
  private String subType;

  public ExpressionType() {
    init();
  }

  public ExpressionType(String mainType, String subType) {
    this();
    this.mainType = mainType;
    this.subType = subType;
  }

  public String getMainType() {
    return mainType;
  }

  public String getSubType() {
    return subType;
  }

  protected void init() {}

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
