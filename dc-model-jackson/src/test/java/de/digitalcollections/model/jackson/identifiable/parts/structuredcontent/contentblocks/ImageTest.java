package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Image;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ImageImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImageTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    Image image = new ImageImpl();
    checkSerializeDeserialize(image);
  }

  @Test
  public void testDeserialization() throws Exception {
    String jsonString =
        "{\n"
            + "  \"type\": \"image\",\n"
            + "  \"attrs\": {\n"
            + "    \"alignment\": \"left\",\n"
            + "    \"altText\": \"This is the alt-text.\",\n"
            + "    \"caption\": \"This is the caption.\",\n"
            + "    \"linkNewTab\": true,\n"
            + "    \"linkUrl\": \"https://external.content.org\",\n"
            + "    \"resourceId\": \"135ec10b-ac65-4217-83fc-db5e9ff62cac\",\n"
            + "    \"title\": \"This is the title.\",\n"
            + "    \"url\": \"https://www.bsb-munchen.de/logo.png\",\n"
            + "    \"width\": \"33%\"\n"
            + "  }\n"
            + "}";

    Image image = mapper.readValue(jsonString, Image.class);

    assertThat(image).isNotNull();
    assertThat(((String) image.getAttribute("alignment"))).isEqualTo("left");
    assertThat(((String) image.getAttribute("altText"))).isEqualTo("This is the alt-text.");
    assertThat(((String) image.getAttribute("caption"))).isEqualTo("This is the caption.");
    assertThat(((boolean) image.getAttribute("linkNewTab"))).isEqualTo(true);
    assertThat(((String) image.getAttribute("linkUrl"))).isEqualTo("https://external.content.org");
    assertThat((String) image.getAttribute("resourceId"))
        .isEqualTo("135ec10b-ac65-4217-83fc-db5e9ff62cac");
    assertThat(((String) image.getAttribute("title"))).isEqualTo("This is the title.");
    assertThat(((String) image.getAttribute("url")))
        .isEqualTo("https://www.bsb-munchen.de/logo.png");
    assertThat(((String) image.getAttribute("width"))).isEqualTo("33%");
  }
}
