package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.EntityType;
import lombok.experimental.SuperBuilder;

/** A family (e.g. the "Clintons"). */
@SuperBuilder(buildMethodName = "prebuild")
public class Family extends Agent {

  public Family() {
    super();
    init();
  }

  @Override
  protected void init() {
    super.init();
    this.entityType = EntityType.FAMILY;
  }

  public abstract static class FamilyBuilder<C extends Family, B extends FamilyBuilder<C, B>>
      extends AgentBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }
  }
}
