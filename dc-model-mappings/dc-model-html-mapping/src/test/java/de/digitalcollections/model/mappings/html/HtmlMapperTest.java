package de.digitalcollections.model.mappings.html;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.digitalcollections.model.text.StructuredContent;
import org.junit.jupiter.api.Test;

public class HtmlMapperTest {

  @Test
  public void testHtml2StructuredContentSimpleUnorderedList() {
    String html = "<ul><li>item 1</li><li>item 2</li></ul>";

    StructuredContent sc = HtmlMapper.toStructuredContent(html);
    assertEquals(1, sc.getContentBlocks().size());
  }

  @Test
  public void testHtml2StructuredContentHierarchicalUnorderedList() {
    String html =
        "<ul>"
            + "<li>item 1"
            + "  <ul>"
            + "  <li>item 1.1</li>"
            + "  <li>item 1.2</li>"
            + "  </ul>"
            + "</li>"
            + "<li>item 2</li>"
            + "</ul>";

    StructuredContent sc = HtmlMapper.toStructuredContent(html);
    assertEquals(1, sc.getContentBlocks().size());
  }
}
