package de.digitalcollections.model.mappings.html;

import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.BulletList;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.ContentBlockNode;
import de.digitalcollections.model.text.contentblock.ListItem;
import de.digitalcollections.model.text.contentblock.Mark;
import de.digitalcollections.model.text.contentblock.Text;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

public class HtmlMapper {

  private static ContentBlock getContentBlock(Node node) {
    ContentBlock contentBlock = null;

    if (node instanceof Element) {
      Element element = (Element) node;
      String tagName = element.tagName();

      if ("ul".equalsIgnoreCase(tagName)) {
        contentBlock = new BulletList();
      } else if ("li".equalsIgnoreCase(tagName)) {
        contentBlock = new ListItem();
      } else if ("a".equalsIgnoreCase(tagName)) {
        // TODO only simple plain text links are supported until now; dive into nodes of a-element
        // for further linked content
        String text = element.text();
        contentBlock = new Text(text);
        String href = element.attr("href");
        Mark link = new Mark("link");
        link.addAttribute("href", href);
        ((Text) contentBlock).addMark(link);
      } else {
        System.out.println("Unsupported element " + tagName + ": " + node.toString());
      }

      if (contentBlock != null
          && contentBlock instanceof ContentBlockNode
          && element.childNodeSize() > 0) {
        List<Node> children = element.childNodes();
        for (Node child : children) {
          ContentBlock childContentBlock = getContentBlock(child);
          ((ContentBlockNode) contentBlock).addContentBlock(childContentBlock);
        }
      }
    } else if (node instanceof TextNode) {
      TextNode textNode = (TextNode) node;
      contentBlock = new Text(textNode.text());
    }

    return contentBlock;
  }

  public static StructuredContent toStructuredContent(String html) {
    StructuredContent structuredContent = new StructuredContent();

    Document doc = Jsoup.parse(html);
    Element body = doc.body();

    List<Node> childNodes = body.childNodes();

    for (Node childNode : childNodes) {
      ContentBlock contentBlock = getContentBlock(childNode);
      structuredContent.addContentBlock(contentBlock);
    }

    return structuredContent;
  }
}
