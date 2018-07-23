package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.HardBreak;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HardBreakImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HardBreakTest extends BaseSerializationTest {

  public ObjectMapper mapper;

  @Before
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  public void testDefaultConstructor() throws Exception {
    HardBreak hardBreak = new HardBreakImpl();

    checkSerializeDeserialize(hardBreak);
  }

  @Test
  public void testDeserialization() throws Exception {
    String jsonString = "{\n"
            + "          \"type\": \"hard_break\"\n"
            + "        }";

    HardBreak hardBreak = mapper.readValue(jsonString, HardBreak.class);
    assertThat(hardBreak).isNotNull();
  }

}
