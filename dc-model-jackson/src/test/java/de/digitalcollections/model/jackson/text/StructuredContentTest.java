package de.digitalcollections.model.jackson.text;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Text;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StructuredContentTest extends BaseJsonSerializationTest {

  private static final String JSON =
      "{      \"type\": \"doc\",\n"
          + "  \"content\": [\n"
          + "    {\n"
          + "      \"type\": \"text\",\n"
          + "      \"text\": \"Test\"\n"
          + "    }\n"
          + "  ]\n"
          + "}";

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testSerialization() throws Exception {
    StructuredContent structuredContent = new StructuredContent();

    List<ContentBlock> contentBlocks = new ArrayList<>();
    contentBlocks.add(new Text("Test"));
    structuredContent.setContentBlocks(contentBlocks);

    checkSerializeDeserialize(structuredContent);

    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(structuredContent);
    assertThat(json.replaceAll("\\s", "")).isEqualTo(JSON.replaceAll("\\s", ""));
  }

  @Test
  public void testDeserializationWithText() throws Exception {

    StructuredContent structuredContent = mapper.readValue(JSON, StructuredContent.class);
    assertThat(structuredContent).isNotNull();
    assertThat(structuredContent.getContentBlocks().size()).isEqualTo(1);
    assertThat(((Text) structuredContent.getContentBlocks().get(0)).getText()).isEqualTo("Test");
  }
}
