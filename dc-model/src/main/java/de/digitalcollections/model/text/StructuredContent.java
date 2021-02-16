package de.digitalcollections.model.text;

import de.digitalcollections.model.text.contentblock.ContentBlock;
import java.util.ArrayList;
import java.util.List;

/** A structured content / text implemented as list of content blocks. */
public class StructuredContent {

  private List<ContentBlock> contentBlocks;

  public StructuredContent() {}

  public void addContentBlock(ContentBlock contentBlock) {
    if (getContentBlocks() == null) {
      setContentBlocks(new ArrayList<>());
    }
    getContentBlocks().add(contentBlock);
  }

  public List<ContentBlock> getContentBlocks() {
    return contentBlocks;
  }

  public void setContentBlocks(List<ContentBlock> contentBlocks) {
    this.contentBlocks = contentBlocks;
  }
}
