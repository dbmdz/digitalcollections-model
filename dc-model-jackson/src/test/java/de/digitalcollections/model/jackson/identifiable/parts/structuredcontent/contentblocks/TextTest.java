package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Mark;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.MarkImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
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
    Text text = new TextImpl();

    checkSerializeDeserialize(text);
  }

  @Test
  public void testWithConstructor() throws Exception {
    Text text = new TextImpl("TEST");

    checkSerializeDeserialize(text);
  }

  @Test
  public void testWithSetters() throws Exception {
    Text text = new TextImpl();
    text.setText("TEST");

    checkSerializeDeserialize(text);
  }

  @Test
  public void testOnlyMarks() throws Exception {
    Text text = new TextImpl();
    text.addMark(new MarkImpl("strong"));
    text.addMark(new MarkImpl("em"));

    checkSerializeDeserialize(text);
  }

  @Test
  public void testConstructorAndMarks() throws Exception {
    Text text = new TextImpl("TEST");
    text.addMark(new MarkImpl("strong"));
    text.addMark(new MarkImpl("em"));
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

    Mark strong = new MarkImpl("strong");
    Mark em = new MarkImpl("em");
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
    Mark strong = new MarkImpl("strong");
    Mark em = new MarkImpl("em");
    assertThat(text.getMarks()).containsExactly(strong, em);
  }
}
