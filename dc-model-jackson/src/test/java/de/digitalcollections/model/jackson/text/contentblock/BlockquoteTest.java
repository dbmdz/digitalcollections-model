package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.Blockquote;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.text.contentblock.Text;
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
    Blockquote blockquote = new Blockquote();
    checkSerializeDeserialize(blockquote);
  }

  @Test
  public void testWithParagraphAsContent() throws Exception {
    Blockquote blockquote = new Blockquote();
    Paragraph paragraph = new Paragraph();
    Text content = new Text("Das ist ein Test");
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

    Text text = new Text("test 1");
    Paragraph paragraph = new Paragraph();
    paragraph.addContentBlock(text);

    assertThat(blockquote.getContentBlocks()).containsExactly(paragraph);
  }
}
