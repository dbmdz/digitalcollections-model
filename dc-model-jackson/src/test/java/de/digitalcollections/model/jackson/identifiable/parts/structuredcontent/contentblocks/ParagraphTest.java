package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.HardBreak;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HardBreakImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.MarkImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
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
    Paragraph paragraph = new ParagraphImpl();

    checkSerializeDeserialize(paragraph);
  }

  @Test
  public void testWithOneContent() throws Exception {
    Paragraph paragraph = new ParagraphImpl();
    Text text = new TextImpl("Imprint");
    paragraph.addContentBlock(text);

    checkSerializeDeserialize(paragraph);
  }

  @Test
  public void testWithMultipleContents() throws Exception {
    Paragraph paragraph = new ParagraphImpl();
    Text text1 = new TextImpl("Imprint");
    paragraph.addContentBlock(text1);
    Text text2 = new TextImpl("Privacy");
    paragraph.addContentBlock(text2);

    checkSerializeDeserialize(paragraph);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString = "{\n"
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

    Text text1 = new TextImpl("Teststreet 16");
    HardBreak hardBreak = new HardBreakImpl();
    Text text2 = new TextImpl("12345 Munich");
    assertThat(paragraph.getContentBlocks()).containsExactly(text1, hardBreak, text2);
  }

  @Test
  public void testDeserializationWithContentsWithMarks() throws Exception {
    String jsonString = "{\n"
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

    Text text1 = new TextImpl("Phone:");
    text1.addMark(new MarkImpl("strong"));

    Text text2 = new TextImpl(" +49 00 11111-0");

    HardBreak hardBreak = new HardBreakImpl();

    Text text3 = new TextImpl("Fax:");
    text3.addMark(new MarkImpl("strong"));
    text3.addMark(new MarkImpl("em"));

    Text text4 = new TextImpl(" +49 00 11111-1");

    assertThat(paragraph.getContentBlocks()).containsExactly(text1, text2, hardBreak, text3, text4);
  }
}
