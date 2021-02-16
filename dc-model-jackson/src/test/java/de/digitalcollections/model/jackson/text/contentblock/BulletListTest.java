package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.BulletList;
import de.digitalcollections.model.text.contentblock.ListItem;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.text.contentblock.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BulletListTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    BulletList bulletList = new BulletList();
    checkSerializeDeserialize(bulletList);
  }

  @Test
  public void testWithListItems() throws Exception {
    BulletList bulletList = new BulletList();

    ListItem item1 = new ListItem();
    Paragraph paragraph1 = new Paragraph();
    Text content1 = new Text("Punkt 1");
    paragraph1.addContentBlock(content1);
    item1.addContentBlock(paragraph1);
    bulletList.addContentBlock(item1);

    ListItem item2 = new ListItem();
    Paragraph paragraph2 = new Paragraph();
    Text content2 = new Text("Punkt 2");
    paragraph2.addContentBlock(content2);
    item2.addContentBlock(paragraph2);
    bulletList.addContentBlock(item2);

    checkSerializeDeserialize(bulletList);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString =
        "{\n"
            + "  \"type\": \"bullet_list\",\n"
            + "  \"content\": [\n"
            + "    {\n"
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
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"list_item\",\n"
            + "      \"content\": [\n"
            + "        {\n"
            + "          \"type\": \"paragraph\",\n"
            + "          \"content\": [\n"
            + "            {\n"
            + "              \"type\": \"text\",\n"
            + "              \"text\": \"test 2\"\n"
            + "            }\n"
            + "          ]\n"
            + "        }\n"
            + "      ]\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"list_item\",\n"
            + "      \"content\": [\n"
            + "        {\n"
            + "          \"type\": \"paragraph\",\n"
            + "          \"content\": [\n"
            + "            {\n"
            + "              \"type\": \"text\",\n"
            + "              \"text\": \"test 3\"\n"
            + "            }\n"
            + "          ]\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";

    BulletList bulletList = mapper.readValue(jsonString, BulletList.class);

    Paragraph paragraph1 = new Paragraph();
    paragraph1.addContentBlock(new Text("test 1"));
    ListItem item1 = new ListItem();
    item1.addContentBlock(paragraph1);

    Paragraph paragraph2 = new Paragraph();
    paragraph2.addContentBlock(new Text("test 2"));
    ListItem item2 = new ListItem();
    item2.addContentBlock(paragraph2);

    Paragraph paragraph3 = new Paragraph();
    paragraph3.addContentBlock(new Text("test 3"));
    ListItem item3 = new ListItem();
    item3.addContentBlock(paragraph3);

    assertThat(bulletList.getContentBlocks()).containsExactly(item1, item2, item3);
  }
}
