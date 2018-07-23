package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Mark;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextImpl extends ContentBlockImpl implements Text {

  private String text;
  private List<Mark> marks;

  public TextImpl() {
  }

  public TextImpl(String text) {
    this.text = text;
  }

  public TextImpl(String text, String... marks) {
    this(text);
    if (marks != null) {
      for (String markStr : marks) {
        Mark mark = new MarkImpl(markStr);
        addMark(mark);
      }
    }

  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  public void setText(String text) {
    this.text = text;
  }

  @Override
  public List<Mark> getMarks() {
    return marks;
  }

  @Override
  public void setMarks(List<Mark> marks) {
    this.marks = marks;
  }

  @Override
  public void addMark(Mark mark) {
    if (marks == null) {
      marks = new ArrayList<>();
    }

    marks.add(mark);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TextImpl)) {
      return false;
    }
    TextImpl text1 = (TextImpl) o;
    return Objects.equals(text, text1.text)
            && Objects.equals(marks, text1.marks);
  }

  @Override
  public int hashCode() {

    return Objects.hash(text, marks);
  }

  @Override
  public String toString() {
    return "TextImpl{"
            + "text='" + text + "\', "
            + "marks=" + marks + ", "
            + "hashCode=" + hashCode()
            + '}';
  }
}
