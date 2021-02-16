package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.Mark;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarkTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testConstructor() throws Exception {
    Mark mark = new Mark("strong");
    checkSerializeDeserialize(mark);
  }

  @Test
  public void testSetter() throws Exception {
    Mark mark = new Mark();
    mark.setType("em");

    checkSerializeDeserialize(mark);
  }

  @Test
  public void testTypeAndAttributes() throws Exception {
    Mark mark = new Mark();
    mark.setType("link");
    mark.addAttribute("href", "https://www.example.org");

    checkSerializeDeserialize(mark);
  }

  @Test
  public void testDeserialization() throws Exception {
    String jsonString = "{\n" + "          \"type\": \"em\"\n" + "        }";

    Mark mark = mapper.readValue(jsonString, Mark.class);
    assertThat(mark).isNotNull();
    assertThat(mark.getType()).isEqualTo("em");
  }

  @Test
  public void testDeserializationWithAttributes() throws Exception {
    String jsonString =
        "{\n"
            + "          \"type\": \"link\",\n"
            + "          \"attrs\": {\n"
            + "             \"href\": \"https://www.example.org/\",\n"
            + "             \"title\": null\n"
            + "          }\n"
            + "        }";

    Mark mark = mapper.readValue(jsonString, Mark.class);
    assertThat(mark).isNotNull();
    assertThat(mark.getType()).isEqualTo("link");
    Map<String, Object> expectedAttributes = new HashMap<>();
    expectedAttributes.put("href", "https://www.example.org/");
    expectedAttributes.put("title", null);
    assertThat(mark.getAttributes()).isEqualTo(expectedAttributes);
  }
}
