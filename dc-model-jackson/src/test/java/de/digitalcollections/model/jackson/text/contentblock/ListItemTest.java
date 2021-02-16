package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.ListItem;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.text.contentblock.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListItemTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    ListItem listItem = new ListItem();
    checkSerializeDeserialize(listItem);
  }

  @Test
  public void testWithParagraphAsContent() throws Exception {
    ListItem listItem = new ListItem();
    Paragraph paragraph = new Paragraph();
    Text content = new Text("This is a test.");
    paragraph.addContentBlock(content);
    listItem.addContentBlock(content);

    checkSerializeDeserialize(listItem);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString =
        "{\n"
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

    Text text = new Text("test 1");
    Paragraph paragraph = new Paragraph();
    paragraph.addContentBlock(text);

    assertThat(listItem.getContentBlocks()).containsExactly(paragraph);
  }
}
