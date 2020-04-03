package de.digitalcollections.model.xml.xstream;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.io.Resources;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.XmlMappingException;

public class WebpageTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebpageTest.class);

  private static DigitalCollectionsXStreamMarshaller marshaller;

  public WebpageTest() {}

  @BeforeAll
  public static void setUpClass() {
    marshaller = new DigitalCollectionsXStreamMarshaller();
  }

  @Test
  public void testMarshallWebpage() throws XmlMappingException, IOException {
    Webpage webpage = WebpageFactory.create();

    final StringWriter sw = new StringWriter();
    marshaller.marshalWriter(webpage, sw);
    String result = sw.toString();

    LOGGER.info(result);

    String webpageXml = readFromResources("serializedTestObjects/webpage.xml");
    assertThat(result).isEqualTo(webpageXml);
  }

  private String readFromResources(String filename) throws IOException {
    return Resources.toString(Resources.getResource(filename), Charset.defaultCharset());
  }
}
