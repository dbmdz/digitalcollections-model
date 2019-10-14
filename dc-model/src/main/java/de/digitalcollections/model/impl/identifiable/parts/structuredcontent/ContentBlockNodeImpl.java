package de.digitalcollections.model.impl.identifiable.parts.structuredcontent;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlockNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ContentBlockNodeImpl extends ContentBlockImpl implements ContentBlockNode {

  protected List<ContentBlock> contentBlocks;

  @Override
  public List<ContentBlock> getContentBlocks() {
    return contentBlocks;
  }

  @Override
  public void setContentBlocks(List<ContentBlock> contentBlocks) {
    this.contentBlocks = contentBlocks;
  }

  @Override
  public void addContentBlock(ContentBlock contentBlock) {
    if (contentBlocks == null) {
      contentBlocks = new ArrayList<>();
    }

    contentBlocks.add(contentBlock);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ContentBlockNodeImpl)) {
      return false;
    }
    ContentBlockNodeImpl that = (ContentBlockNodeImpl) o;
    return Objects.equals(contentBlocks, that.contentBlocks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentBlocks);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
        + "{"
        + "contentBlocks="
        + contentBlocks
        + ", "
        + "hashCode="
        + hashCode()
        + '}';
  }
}
