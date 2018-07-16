package de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import java.util.List;

public interface Text extends ContentBlock {

  String getText();

  void setText(String text);

  List<Mark> getMarks();

  void setMarks(List<Mark> marks);

  void addMark(Mark mark);

}
