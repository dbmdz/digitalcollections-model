package de.digitalcollections.model.jackson.identifiable.parts;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizedTextTest extends BaseJsonSerializationTest {

  private static final String JSON = "{\n"
                                     + "\"it_IT\": \"Buon Giorno!\"\n"
                                     + "}";

  private static LocalizedText localizedText;
  private ObjectMapper mapper;

  @BeforeAll
  public static void setUpGlobal() {
    localizedText = new LocalizedTextImpl(Locale.ITALY, "Buon Giorno!");
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
