package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.CodeBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.text.contentblock.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CodeBlockTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    CodeBlock codeBlock = new CodeBlock();
    checkSerializeDeserialize(codeBlock);
  }

  @Test
  public void testWithParagraphAsContent() throws Exception {
    CodeBlock codeBlock = new CodeBlock();
    Paragraph paragraph = new Paragraph();
    Text content = new Text("Das ist ein Test");
    paragraph.addContentBlock(content);
    codeBlock.addContentBlock(content);

    checkSerializeDeserialize(codeBlock);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString =
        "{\n"
            + "      \"type\": \"code_block\",\n"
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

    CodeBlock codeBlock = mapper.readValue(jsonString, CodeBlock.class);
    assertThat(codeBlock).isNotNull();
    assertThat(codeBlock.getContentBlocks()).isNotNull();

    Text text = new Text("test 1");
    Paragraph paragraph = new Paragraph();
    paragraph.addContentBlock(text);

    assertThat(codeBlock.getContentBlocks()).containsExactly(paragraph);
  }
}
