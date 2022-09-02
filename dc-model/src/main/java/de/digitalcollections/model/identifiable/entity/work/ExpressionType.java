package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.MainSubType;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class ExpressionType extends MainSubType {

  public ExpressionType() {
    super();
  }

  public ExpressionType(String mainType, String subType) {
    super(mainType, subType);
  }

  public abstract static class ExpressionTypeBuilder<
          C extends ExpressionType, B extends ExpressionTypeBuilder<C, B>>
      extends MainSubTypeBuilder<C, B> {

    public C build() {
      C c = prebuild();
      return c;
    }
  }
}
