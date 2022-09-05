package de.digitalcollections.model;

import java.util.Objects;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class MainSubType {

  private String mainType;
  private String subType;

  public MainSubType() {}

  public MainSubType(String mainType, String subType) {
    this();
    this.mainType = mainType.toUpperCase();
    this.subType = subType.toUpperCase();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof MainSubType)) {
      return false;
    }
    MainSubType other = (MainSubType) obj;
    return Objects.equals(mainType, other.mainType) && Objects.equals(subType, other.subType);
  }

  @Override
  public int hashCode() {
    return (mainType != null ? mainType.hashCode() : 0)
        + (subType != null ? subType.hashCode() : 0)
        + 187;
  }

  public String getMainType() {
    return mainType;
  }

  public String getSubType() {
    return subType;
  }

  public void setMainType(String mainType) {
    this.mainType = mainType.toUpperCase();
  }

  public void setSubType(String subType) {
    this.subType = subType.toUpperCase();
  }

  public abstract static class MainSubTypeBuilder<
      C extends MainSubType, B extends MainSubTypeBuilder<C, B>> {

    public B mainType(String mainType) {
      this.mainType = mainType.toUpperCase();
      return self();
    }

    public B subType(String subType) {
      this.subType = subType.toUpperCase();
      return self();
    }
  }

  @Override
  public String toString() {
    return "MainSubType{" + "mainType='" + mainType + '\'' + ", subType='" + subType + '\'' + '}';
  }
}
