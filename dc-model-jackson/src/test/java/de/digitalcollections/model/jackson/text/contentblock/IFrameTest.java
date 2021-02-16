package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.IFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IFrameTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    IFrame iframe = new IFrame();
    checkSerializeDeserialize(iframe);
  }

  @Test
  public void testDeserialization() throws Exception {
    String jsonString =
        "{\n"
            + "  \"type\": \"iframe\",\n"
            + "  \"attrs\": {\n"
            + "    \"src\": \"https://www.example.org/index.php?module=CoreAdminHome&amp;action=optOut&amp;language=de\",\n"
            + "    \"width\": \"98%\",\n"
            + "    \"height\": \"auto\"\n"
            + "  }\n"
            + "}";

    IFrame iframe = mapper.readValue(jsonString, IFrame.class);

    assertThat(iframe).isNotNull();
    assertThat(((String) iframe.getAttribute("src")))
        .isEqualTo(
            "https://www.example.org/index.php?module=CoreAdminHome&amp;action=optOut&amp;language=de");
    assertThat(((String) iframe.getAttribute("height"))).isEqualTo("auto");
    assertThat(((String) iframe.getAttribute("width"))).isEqualTo("98%");
  }
}
