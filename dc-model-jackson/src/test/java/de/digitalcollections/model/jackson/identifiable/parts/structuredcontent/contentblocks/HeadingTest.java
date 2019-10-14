package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Heading;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HeadingImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeadingTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    Heading heading = new HeadingImpl();

    checkSerializeDeserialize(heading);
  }

  @Test
  public void testWithTextContentOnly() throws Exception {
    Heading heading = new HeadingImpl();
    Text text = new TextImpl("Imprint");
    heading.addContentBlock(text);

    checkSerializeDeserialize(heading);
  }

  @Test
  public void testWithAttributesOnly() throws Exception {
    Heading heading = new HeadingImpl();
    heading.addAttribute("level", 3);

    checkSerializeDeserialize(heading);
  }

  @Test
  public void testDeserializationWithEmptyContentAndEmptyAttributes() throws Exception {
    String jsonString = "{\n" + "          \"type\": \"heading\"\n" + "        }";

    Heading heading = mapper.readValue(jsonString, Heading.class);
    assertThat(heading).isNotNull();
    assertThat(heading.getAttributes()).isNull();
    assertThat(heading.getContentBlocks()).isNull();
  }

  @Test
  public void testDeserializationWithAttributesOnly() throws Exception {
    String jsonString =
        "{\n"
            + "      \"type\": \"heading\",\n"
            + "      \"attrs\": {\n"
            + "        \"level\": 3\n"
            + "      }\n"
            + "    },";

    Heading heading = mapper.readValue(jsonString, Heading.class);
    assertThat(heading).isNotNull();
    assertThat(heading.getAttributes()).isNotNull();
    assertThat(heading.getAttribute("level")).isEqualTo(3);
    assertThat(heading.getAttribute("foo")).isNull();
  }

  @Test
  public void testDeserializationWithAttributesAndContent() throws Exception {
    String jsonString =
        "{\n"
            + "      \"type\": \"heading\",\n"
            + "      \"attrs\": {\n"
            + "        \"level\": 3\n"
            + "      },\n"
            + "  \"content\": [\n"
            + "    {\n"
            + "      \"type\": \"text\",\n"
            + "      \"text\": \"Imprint\"\n"
            + "    }\n"
            + "  ]\n"
            + "    },";

    Heading heading = mapper.readValue(jsonString, Heading.class);
    assertThat(heading).isNotNull();
    assertThat(heading.getAttributes()).isNotNull();
    assertThat(heading.getAttribute("level")).isEqualTo(3);
    assertThat(heading.getAttribute("foo")).isNull();
    assertThat(heading.getContentBlocks()).isNotEmpty();
    Text impressum = new TextImpl("Imprint");
    assertThat(heading.getContentBlocks().get(0)).isEqualTo(impressum);
  }
}
