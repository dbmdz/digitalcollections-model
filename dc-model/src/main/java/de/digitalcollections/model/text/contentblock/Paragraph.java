package de.digitalcollections.model.text.contentblock;

/** A paragraph (can contain text and other content blocks). */
public class Paragraph extends ContentBlockNode {

  public Paragraph() {}

  public Paragraph(String text) {
    addContentBlock(new Text(text));
  }
}
