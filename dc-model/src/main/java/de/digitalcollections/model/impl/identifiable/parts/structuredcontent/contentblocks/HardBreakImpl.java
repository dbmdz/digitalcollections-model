package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.HardBreak;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockImpl;

public class HardBreakImpl extends ContentBlockImpl implements HardBreak {

  @Override
  public int hashCode() {
    return -1;
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof HardBreak);
  }

  @Override
  public String toString() {
    return "HardBreakImpl{hashCode=" + hashCode() + "}";
  }
}
