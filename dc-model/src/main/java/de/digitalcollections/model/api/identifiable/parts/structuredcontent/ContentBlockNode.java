package de.digitalcollections.model.api.identifiable.parts.structuredcontent;

import java.util.ArrayList;
import java.util.List;

public interface ContentBlockNode extends ContentBlock {

  List<ContentBlock> getContentBlocks();

  void setContentBlocks(List<ContentBlock> contentBlocks);

  default void addContentBlock(ContentBlock contentBlock) {
    if (getContentBlocks() == null) {
      setContentBlocks(new ArrayList<>());
    }
    getContentBlocks().add(contentBlock);
  }
}
