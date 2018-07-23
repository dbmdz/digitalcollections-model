package de.digitalcollections.model.impl.identifiable.parts.structuredcontent;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import java.util.List;

public class StructuredContentImpl implements StructuredContent {

  List<ContentBlock> contentBlocks;

  public StructuredContentImpl() {
  }

  @Override
  public List<ContentBlock> getContentBlocks() {
    return contentBlocks;
  }

  @Override
  public void setContentBlocks(List<ContentBlock> contentBlocks) {
    this.contentBlocks = contentBlocks;
  }
}
