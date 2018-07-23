package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.ListItem;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ListItemImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListItemTest extends BaseSerializationTest {

  public ObjectMapper mapper;

  @Before
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    ListItem listItem = new ListItemImpl();

    checkSerializeDeserialize(listItem);
  }

  @Test
  public void testWithParagraphAsContent() throws Exception {
    ListItem listItem = new ListItemImpl();
    Paragraph paragraph = new ParagraphImpl();
    Text content = new TextImpl("This is a test.");
    paragraph.addContentBlock(content);
    listItem.addContentBlock(content);

    checkSerializeDeserialize(listItem);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString = "{\n"
            + "      \"type\": \"list_item\",\n"
            + "      \"content\": [\n"
            + "        {\n"
            + "          \"type\": \"paragraph\",\n"
            + "          \"content\": [\n"
            + "            {\n"
            + "              \"type\": \"text\",\n"
            + "              \"text\": \"test 1\"\n"
            + "            }\n"
            + "          ]\n"
            + "        }\n"
            + "      ]\n"
            + "    }";

    ListItem listItem = mapper.readValue(jsonString, ListItem.class);
    assertThat(listItem).isNotNull();
    assertThat(listItem.getContentBlocks()).isNotNull();

    Text text = new TextImpl("test 1");
    Paragraph paragraph = new ParagraphImpl();
    paragraph.addContentBlock(text);

    assertThat(listItem.getContentBlocks()).containsExactly(paragraph);
  }

}
