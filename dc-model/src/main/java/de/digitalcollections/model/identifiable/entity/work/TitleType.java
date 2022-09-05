package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.MainSubType;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class TitleType extends MainSubType {

  public TitleType() {
    super();
  }

  public TitleType(String mainType, String subType) {
    super(mainType, subType);
  }
}
