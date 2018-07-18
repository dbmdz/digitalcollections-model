package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.IFrame;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.IFrameImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

public class IFrameTest extends BaseSerializationTest {

  public ObjectMapper mapper;

  @Before
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    IFrame embeddedCodeBlock = new IFrameImpl();

    checkSerializeDeserialize(embeddedCodeBlock);
  }

  @Test
  public void testDeserialization() throws Exception {
    String jsonString = "{\n"
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
            .isEqualTo("https://www.example.org/index.php?module=CoreAdminHome&amp;action=optOut&amp;language=de");
    assertThat(((String) iframe.getAttribute("height"))).isEqualTo("auto");
    assertThat(((String) iframe.getAttribute("width"))).isEqualTo("98%");
  }

}
