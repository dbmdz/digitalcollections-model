package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.MainSubType;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class TitleType extends MainSubType {

  public TitleType() {
    super();
  }

  public TitleType(String mainType, String subType) {
    super(mainType, subType);
  }

  public abstract static class TitleTypeBuilder<
          C extends TitleType, B extends TitleTypeBuilder<C, B>>
      extends MainSubTypeBuilder<C, B> {

    public C build() {
      C c = prebuild();
      return c;
    }
  }
}
