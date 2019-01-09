package de.digitalcollections.model.jackson.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Heading;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.IFrame;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Mark;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Paragraph;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Text;
import de.digitalcollections.model.impl.identifiable.entity.parts.WebpageImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HeadingImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.IFrameImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.MarkImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import java.util.Locale;

public class WebpageFactory {

  public static Webpage create() {
    Webpage webpage = new WebpageImpl();

    webpage.setLabel(new LocalizedTextImpl(Locale.GERMANY, "Meine Homepage"));

    LocalizedStructuredContent description = new LocalizedStructuredContentImpl();
    StructuredContent structuredContent = new StructuredContentImpl();
    Paragraph p = new ParagraphImpl("");
    structuredContent.addContentBlock(p);
    description.add(Locale.GERMANY, structuredContent);
    webpage.setDescription(description);

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

    LocalizedStructuredContent text = new LocalizedStructuredContentImpl();
    text.add(Locale.GERMANY, structuredContent);
    webpage.setText(text);

    return webpage;
  }
}
