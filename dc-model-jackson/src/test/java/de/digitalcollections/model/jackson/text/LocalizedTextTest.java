package de.digitalcollections.model.jackson.text;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocalizedTextTest extends BaseJsonSerializationTest {

  private static final String JSON = "{\n" + "\"it_IT\": \"Buon Giorno!\"\n" + "}";

  private static LocalizedText localizedText;
  private ObjectMapper mapper;

  @BeforeAll
  public static void setUpGlobal() {
    localizedText = new LocalizedText(Locale.ITALY, "Buon Giorno!");
  }

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testSerialisationInBothWays() throws Exception {
    checkSerializeDeserialize(localizedText);
  }

  @Test
  public void testDeserialization() throws Exception {
    LocalizedText lt = mapper.readValue(JSON, LocalizedText.class);
    assertThat(lt).isNotNull();
    assertThat(lt.getLocales().size()).isEqualTo(1);
    assertThat(lt.getText(Locale.ITALY)).isEqualTo("Buon Giorno!");
  }

  @Test
  public void testSerialization() throws Exception {
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(localizedText);
    assertThat(json.replaceAll("\\s", "")).isEqualTo(JSON.replaceAll("\\s", ""));
  }
}
