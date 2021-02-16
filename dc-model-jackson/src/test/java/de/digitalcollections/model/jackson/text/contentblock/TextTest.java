package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.Mark;
import de.digitalcollections.model.text.contentblock.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    Text text = new Text();

    checkSerializeDeserialize(text);
  }

  @Test
  public void testWithConstructor() throws Exception {
    Text text = new Text("TEST");

    checkSerializeDeserialize(text);
  }

  @Test
  public void testWithSetters() throws Exception {
    Text text = new Text();
    text.setText("TEST");

    checkSerializeDeserialize(text);
  }

  @Test
  public void testOnlyMarks() throws Exception {
    Text text = new Text();
    text.addMark(new Mark("strong"));
    text.addMark(new Mark("em"));

    checkSerializeDeserialize(text);
  }

  @Test
  public void testConstructorAndMarks() throws Exception {
    Text text = new Text("TEST");
    text.addMark(new Mark("strong"));
    text.addMark(new Mark("em"));
    checkSerializeDeserialize(text);
  }

  @Test
  public void testDeserializationWithEmptyText() throws Exception {
    String jsonString = "{\n" + "          \"type\": \"text\"\n" + "        }";

    Text text = mapper.readValue(jsonString, Text.class);
    assertThat(text).isNotNull();
    assertThat(text.getText()).isNull();
  }

  @Test
  public void testDeserializationWithText() throws Exception {
    String jsonString =
        "{\n"
            + "          \"type\": \"text\",\n"
            + "          \"text\": \"Imprint\"\n"
            + "        }";

    Text text = mapper.readValue(jsonString, Text.class);
    assertThat(text).isNotNull();
    assertThat(text.getText()).isEqualTo("Imprint");
    assertThat(text.getMarks()).isNull();
  }

  @Test
  public void testDeserializationWithMarksOnly() throws Exception {
    String jsonString =
        "{\n"
            + "      \"type\": \"text\",\n"
            + "      \"marks\": [\n"
            + "        {\"type\":\"strong\"},\n"
            + "        {\"type\":\"em\"}\n"
            + "      ]\n"
            + "    }";

    Text text = mapper.readValue(jsonString, Text.class);
    assertThat(text).isNotNull();
    assertThat(text.getText()).isNull();

    Mark strong = new Mark("strong");
    Mark em = new Mark("em");
    assertThat(text.getMarks()).containsExactly(strong, em);
  }

  @Test
  public void testDeserializationWithTextAndMarks() throws Exception {
    String jsonString =
        "{\n"
            + "      \"type\": \"text\",\n"
            + "      \"marks\": [\n"
            + "        {\"type\":\"strong\"},\n"
            + "        {\"type\":\"em\"}\n"
            + "      ],\n"
            + "      \"text\": \"Fax:\"\n"
            + "    }";

    Text text = mapper.readValue(jsonString, Text.class);
    assertThat(text).isNotNull();
    assertThat(text.getText()).isEqualTo("Fax:");
    Mark strong = new Mark("strong");
    Mark em = new Mark("em");
    assertThat(text.getMarks()).containsExactly(strong, em);
  }
}
