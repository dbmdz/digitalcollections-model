package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.HardBreak;
import de.digitalcollections.model.text.contentblock.Mark;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.text.contentblock.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParagraphTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    Paragraph paragraph = new Paragraph();
    checkSerializeDeserialize(paragraph);
  }

  @Test
  public void testWithOneContent() throws Exception {
    Paragraph paragraph = new Paragraph();
    Text text = new Text("Imprint");
    paragraph.addContentBlock(text);

    checkSerializeDeserialize(paragraph);
  }

  @Test
  public void testWithMultipleContents() throws Exception {
    Paragraph paragraph = new Paragraph();
    Text text1 = new Text("Imprint");
    paragraph.addContentBlock(text1);
    Text text2 = new Text("Privacy");
    paragraph.addContentBlock(text2);

    checkSerializeDeserialize(paragraph);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString =
        "{\n"
            + "  \"type\": \"paragraph\",\n"
            + "  \"content\": [\n"
            + "    {\n"
            + "      \"type\": \"text\",\n"
            + "      \"text\": \"Teststreet 16\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"hard_break\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"text\",\n"
            + "      \"text\": \"12345 Munich\"\n"
            + "    }\n"
            + "  ]\n"
            + "}";

    Paragraph paragraph = mapper.readValue(jsonString, Paragraph.class);
    assertThat(paragraph).isNotNull();
    assertThat(paragraph.getContentBlocks()).isNotNull();

    Text text1 = new Text("Teststreet 16");
    HardBreak hardBreak = new HardBreak();
    Text text2 = new Text("12345 Munich");
    assertThat(paragraph.getContentBlocks()).containsExactly(text1, hardBreak, text2);
  }

  @Test
  public void testDeserializationWithContentsWithMarks() throws Exception {
    String jsonString =
        "{\n"
            + "  \"type\": \"paragraph\",\n"
            + "  \"content\": [\n"
            + "    {\n"
            + "      \"type\": \"text\",\n"
            + "      \"marks\": [\n"
            + "        {\n"
            + "          \"type\": \"strong\"\n"
            + "        }\n"
            + "      ],\n"
            + "      \"text\": \"Phone:\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"text\",\n"
            + "      \"text\": \" +49 00 11111-0\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"hard_break\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"text\",\n"
            + "      \"marks\": [\n"
            + "        {\"type\":\"strong\"},\n"
            + "        {\"type\":\"em\"}\n"
            + "      ],\n"
            + "      \"text\": \"Fax:\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"text\",\n"
            + "      \"text\": \" +49 00 11111-1\"\n"
            + "    }\n"
            + "  ]\n"
            + "}";

    Paragraph paragraph = mapper.readValue(jsonString, Paragraph.class);

    assertThat(paragraph.getContentBlocks()).hasSize(5);

    Text text1 = new Text("Phone:");
    text1.addMark(new Mark("strong"));

    Text text2 = new Text(" +49 00 11111-0");

    HardBreak hardBreak = new HardBreak();

    Text text3 = new Text("Fax:");
    text3.addMark(new Mark("strong"));
    text3.addMark(new Mark("em"));

    Text text4 = new Text(" +49 00 11111-1");

    assertThat(paragraph.getContentBlocks()).containsExactly(text1, text2, hardBreak, text3, text4);
  }
}
