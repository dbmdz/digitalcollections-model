package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Blockquote;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.BlockquoteImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlockquoteTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    BlockquoteImpl blockquote = new BlockquoteImpl();
    checkSerializeDeserialize(blockquote);
  }

  @Test
  public void testWithParagraphAsContent() throws Exception {
    BlockquoteImpl blockquote = new BlockquoteImpl();
    Paragraph paragraph = new ParagraphImpl();
    Text content = new TextImpl("Das ist ein Test");
    paragraph.addContentBlock(content);
    blockquote.addContentBlock(content);

    checkSerializeDeserialize(blockquote);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString =
        "{\n"
            + "      \"type\": \"blockquote\",\n"
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

    Blockquote blockquote = mapper.readValue(jsonString, Blockquote.class);
    assertThat(blockquote).isNotNull();
    assertThat(blockquote.getContentBlocks()).isNotNull();

    Text text = new TextImpl("test 1");
    Paragraph paragraph = new ParagraphImpl();
    paragraph.addContentBlock(text);

    assertThat(blockquote.getContentBlocks()).containsExactly(paragraph);
  }
}
