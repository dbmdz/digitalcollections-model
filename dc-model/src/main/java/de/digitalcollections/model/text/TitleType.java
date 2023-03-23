package de.digitalcollections.model.text;

import de.digitalcollections.model.MainSubType;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class TitleType extends MainSubType {

  public TitleType() {
    super();
  }

  public TitleType(String mainType, String subType) {
    super(mainType, (subType == null || subType.isEmpty() || subType.isBlank()) ? null : subType);
  }

  public void setSubType(String subType) {
    if (subType == null || subType.isEmpty() || subType.isBlank()) {
      super.setSubType(null);
    } else {
      super.setSubType(subType);
    }
  }
}
