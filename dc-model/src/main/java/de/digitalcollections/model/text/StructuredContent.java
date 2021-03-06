package de.digitalcollections.model.text;

import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Heading;
import de.digitalcollections.model.text.contentblock.Text;
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

  public List<ToCEntry> getTableOfContents() {
    if (contentBlocks == null || contentBlocks.isEmpty()) {
      return null;
    }
    List<ToCEntry> toc = new ArrayList<>();
    ToCEntry previousEntry = null;
    int previousLevel = 1;
    int index = -1;
    for (ContentBlock contentBlock : contentBlocks) {
      index++;
      if (contentBlock instanceof Heading) {
        Heading heading = (Heading) contentBlock;
        int currentLevel = (int) heading.getAttribute("level");
        ToCEntry parentEntry = previousEntry;

        ToCEntry currentEntry = new ToCEntry();
        if (currentLevel == 1) {
          toc.add(currentEntry);
        } else {
          // current level > 1
          if (currentLevel == previousLevel) {
            // on the same level than previous entry - same parent
            parentEntry = previousEntry.getParent();
          } else if (currentLevel == previousLevel + 1) {
            // directly under previous node
            parentEntry = previousEntry;
          } else if (currentLevel > previousLevel + 1) {
            // filling up gap between previous level and current level (under previous entry)
            for (int i = previousLevel; i < currentLevel - 1; i++) {
              ToCEntry newParentNode = new ToCEntry();
              newParentNode.setParent(previousEntry);
              previousEntry.addChild(newParentNode);
              previousEntry = newParentNode;
            }
            parentEntry = previousEntry;
          } else if (currentLevel < previousLevel) {
            // e.g. current 2, previous 5 (parent = previous.getparent.getparent ...)
            parentEntry = previousEntry.getParent();
            for (int i = previousLevel; i > currentLevel; i--) {
              parentEntry = parentEntry.getParent();
            }
          }
          currentEntry.setParent(parentEntry);
          parentEntry.addChild(currentEntry);
        }

        // set label
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

        previousEntry = currentEntry;
        previousLevel = currentLevel;
      }
    }
    if (toc.isEmpty()) {
      return null;
    }
    return toc;
  }

  public void setContentBlocks(List<ContentBlock> contentBlocks) {
    this.contentBlocks = contentBlocks;
  }
}
