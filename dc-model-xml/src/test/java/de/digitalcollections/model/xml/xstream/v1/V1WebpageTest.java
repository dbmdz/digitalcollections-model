package de.digitalcollections.model.xml.xstream.v1;

import com.google.common.io.Resources;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.XmlMappingException;

import static org.assertj.core.api.Assertions.assertThat;

public class V1WebpageTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(V1WebpageTest.class);

  private static V1DigitalCollectionsXStreamMarshaller marshaller;

  public V1WebpageTest() {
  }

  @BeforeAll
  public static void setUpClass() {
    marshaller = new V1DigitalCollectionsXStreamMarshaller();
  }

  @Disabled
  @Test
  public void testMarshallWebpage() throws XmlMappingException, IOException {
    Webpage webpage = WebpageFactory.create();

    final StringWriter sw = new StringWriter();
    marshaller.marshalWriter(webpage, sw);
    String result = sw.toString();

    LOGGER.info(result);

    assertThat(result).doesNotContain("localizedStructuredContent");
    assertThat(result).doesNotContain("structuredContent");
    assertThat(result).doesNotContain("contentBlocks");

    String v1WebpageXml = readFromResources("serializedTestObjects/v1Webpage.xml");
    assertThat(result).isEqualTo(v1WebpageXml);
  }

  private String readFromResources(String filename) throws IOException {
    return Resources.toString(Resources.getResource(filename), Charset.defaultCharset());
  }
}
