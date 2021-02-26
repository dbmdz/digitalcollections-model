package de.digitalcollections.model.text;

import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Heading;
import de.digitalcollections.model.text.contentblock.Text;
import de.digitalcollections.model.view.ToC;
import de.digitalcollections.model.view.ToCEntry;
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

  public ToC getTableOfContents() {
    if (contentBlocks == null || contentBlocks.isEmpty()) {
      return null;
    }
    ToC toc = null;
    ToCEntry previousEntry = null;
    int previousLevel = 1;
    int index = -1;
    for (ContentBlock contentBlock : contentBlocks) {
      index++;
      if (contentBlock instanceof Heading) {
        if (toc == null) {
          toc = new ToC();
          previousEntry = toc;
          previousLevel = 0;
        }

        Heading heading = (Heading) contentBlock;
        int currentLevel = (int) heading.getAttribute("level");

        ToCEntry parentEntry = previousEntry;
        if (currentLevel == previousLevel) {
          parentEntry = previousEntry.getParent();
        } else if (currentLevel == previousLevel + 1) {
          // directly under previous node
          parentEntry = previousEntry;
        } else if (currentLevel > previousLevel + 1) {
          for (int i = previousLevel; i < currentLevel - 1; i++) {
            ToCEntry newParentNode = new ToCEntry();
            newParentNode.setParent(previousEntry);
            previousEntry.addChild(newParentNode);
            previousEntry = newParentNode;
          }
          parentEntry = previousEntry;
        } else if (currentLevel < previousLevel) {
          // e.g. current 2, previous 3 (parent = previous.getparent.getparent ...)
          parentEntry = previousEntry.getParent();
          for (int i = previousLevel; i > currentLevel; i--) {
            parentEntry = parentEntry.getParent();
          }
        }
        ToCEntry currentEntry = new ToCEntry();
        currentEntry.setParent(parentEntry);
        Text text =
            (Text)
                heading.getContentBlocks().stream()
                    .filter(
                        cb -> {
                          return cb.getClass() == Text.class;
                        })
                    .findFirst()
                    .orElse(null);
        if (text != null) {
          currentEntry.setLabel(text.getText());
        }
        currentEntry.setTargetId(String.valueOf(index));
        parentEntry.addChild(currentEntry);

        previousLevel = currentLevel;
        previousEntry = currentEntry;
      }
    }
    return toc;
  }

  public void setContentBlocks(List<ContentBlock> contentBlocks) {
    this.contentBlocks = contentBlocks;
  }
}
