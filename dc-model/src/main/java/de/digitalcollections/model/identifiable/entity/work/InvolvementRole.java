package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;
import lombok.experimental.SuperBuilder;

/** An involvement role defines how an agent is involved related to a work. */
@SuperBuilder(buildMethodName = "prebuild")
public class InvolvementRole {

  private LocalizedText label;
  private String name;

  public InvolvementRole() {
    init();
  }

  public InvolvementRole(LocalizedText label, String name) {
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

  public abstract static class InvolvementRoleBuilder<
      C extends InvolvementRole, B extends InvolvementRoleBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
