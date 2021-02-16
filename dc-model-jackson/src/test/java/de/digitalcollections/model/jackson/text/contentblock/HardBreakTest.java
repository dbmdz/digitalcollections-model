package de.digitalcollections.model.jackson.text.contentblock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.contentblock.HardBreak;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HardBreakTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    HardBreak hardBreak = new HardBreak();
    checkSerializeDeserialize(hardBreak);
  }

  @Test
  public void testDeserialization() throws Exception {
    String jsonString = "{\n" + "          \"type\": \"hard_break\"\n" + "        }";

    HardBreak hardBreak = mapper.readValue(jsonString, HardBreak.class);
    assertThat(hardBreak).isNotNull();
  }
}
