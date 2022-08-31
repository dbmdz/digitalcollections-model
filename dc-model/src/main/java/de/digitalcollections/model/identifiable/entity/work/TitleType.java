package de.digitalcollections.model.identifiable.entity.work;

import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class TitleType {

  private String mainType;
  private String subType;

  public TitleType() {
    init();
  }

  public TitleType(String mainType, String subType) {
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

  public abstract static class TitleTypeBuilder<
      C extends TitleType, B extends TitleTypeBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
