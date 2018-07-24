package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.CodeBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.CodeBlockImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CodeBlockTest extends BaseSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    CodeBlockImpl codeBlock = new CodeBlockImpl();
    checkSerializeDeserialize(codeBlock);
  }

  @Test
  public void testWithParagraphAsContent() throws Exception {
    CodeBlockImpl codeBlock = new CodeBlockImpl();
    Paragraph paragraph = new ParagraphImpl();
    Text content = new TextImpl("Das ist ein Test");
    paragraph.addContentBlock(content);
    codeBlock.addContentBlock(content);

    checkSerializeDeserialize(codeBlock);
  }

  @Test
  public void testDeserializationWithContents() throws Exception {
    String jsonString = "{\n"
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

    Text text = new TextImpl("test 1");
    Paragraph paragraph = new ParagraphImpl();
    paragraph.addContentBlock(text);

    assertThat(codeBlock.getContentBlocks()).containsExactly(paragraph);
  }

}
