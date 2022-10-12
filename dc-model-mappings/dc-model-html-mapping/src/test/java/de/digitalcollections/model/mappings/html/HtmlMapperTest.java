package de.digitalcollections.model.mappings.html;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.digitalcollections.model.text.StructuredContent;
import org.junit.jupiter.api.Test;

public class HtmlMapperTest {

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
    // TODO better assert
  }

  @Test
  public void testHtml2StructuredContentSimpleUnorderedList() {
    String html = "<ul><li>item 1</li><li>item 2</li></ul>";

    StructuredContent sc = HtmlMapper.toStructuredContent(html);
    assertEquals(1, sc.getContentBlocks().size());
    // TODO better assert
  }

  @Test
  public void testHtml2StructuredContentSimpleUnorderedListWithLinks() {
    String html =
        "<ul><li>item 1</li><li>Test <a href=\"https://mdz-nbn-resolving.de/view:bsb00009405?page=297\">Erscheinungsjahr: 1956, aufgeführt in ZBLG 22 (1959), Nr.2082</a> Test</li></ul>";

    StructuredContent sc = HtmlMapper.toStructuredContent(html);
    assertEquals(1, sc.getContentBlocks().size());
    // TODO better assert
  }
}
