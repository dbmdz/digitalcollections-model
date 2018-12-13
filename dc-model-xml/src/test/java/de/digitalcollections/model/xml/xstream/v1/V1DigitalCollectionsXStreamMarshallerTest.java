package de.digitalcollections.model.xml.xstream.v1;

import com.google.common.io.Resources;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Heading;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.IFrame;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Mark;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.entity.parts.WebpageImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HeadingImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.IFrameImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.MarkImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.oxm.XmlMappingException;

import static org.assertj.core.api.Assertions.assertThat;

public class V1DigitalCollectionsXStreamMarshallerTest {

  private static V1DigitalCollectionsXStreamMarshaller marshaller;

  public V1DigitalCollectionsXStreamMarshallerTest() {
  }

  @BeforeAll
  public static void setUpClass() {
    marshaller = new V1DigitalCollectionsXStreamMarshaller();
  }

  @Test
  public void testMarshallWebpage() throws XmlMappingException, IOException {
    Webpage webpage = new WebpageImpl();

    LocalizedStructuredContent description = new LocalizedStructuredContentImpl();
    StructuredContent structuredContent = new StructuredContentImpl();
    Paragraph p = new ParagraphImpl("");
    structuredContent.addContentBlock(p);
    description.add(Locale.GERMANY, structuredContent);
    webpage.setDescription(description);

    LocalizedStructuredContent text = new LocalizedStructuredContentImpl();
    structuredContent = new StructuredContentImpl();

    Heading h = new HeadingImpl();
    h.addAttribute("level", 4);
    Text t = new TextImpl("Bayerische Staatsbibliothek");
    Mark m = new MarkImpl("strong");
    t.addMark(m);
    h.addContentBlock(t);
    structuredContent.addContentBlock(h);

    Paragraph p2 = new ParagraphImpl();
    p2.addContentBlock(new TextImpl("Internet:", "strong"));
    p2.addContentBlock(new TextImpl("   "));
    Text link = new TextImpl("www.bsb-muenchen.de");
    Mark linkMark = new MarkImpl("link");
    linkMark.addAttribute("href", "https://www.bsb-muenchen.de/");
    link.addMark(linkMark);
    p2.addContentBlock(link);
    structuredContent.addContentBlock(p2);

    IFrame iFrame = new IFrameImpl("https://external.content.org/index.php?language=de&action=test", "90%", "150px");
    structuredContent.addContentBlock(iFrame);

    text.add(Locale.GERMANY, structuredContent);
    webpage.setText(text);

    final StringWriter sw = new StringWriter();
    marshaller.marshalWriter(webpage, sw);
    String result = sw.toString();
    System.out.println(result);
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
