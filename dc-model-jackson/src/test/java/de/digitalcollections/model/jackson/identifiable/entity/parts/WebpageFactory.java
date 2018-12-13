package de.digitalcollections.model.jackson.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.entity.parts.WebpageImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HardBreakImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HeadingImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WebpageFactory {

  public static Webpage create() {
    List<ContentBlock> contents = new ArrayList<>();

    contents.add(new HeadingImpl(3, "Imprint"));
    contents.add(new HeadingImpl(4, "Example Company"));
    contents.add(new ParagraphImpl("Teststreet 16"));
    contents.add(new HardBreakImpl());
    contents.add(new HeadingImpl(4, "Legal representative:"));
    contents.add(new ParagraphImpl("Big Boss Boba"));

    StructuredContent structuredContent = new StructuredContentImpl();
    structuredContent.setContentBlocks(contents);

    Webpage webpage = new WebpageImpl();
    webpage.setLabel(new LocalizedTextImpl(Locale.ENGLISH, "My Webpage"));

    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContentImpl();
    localizedStructuredContent.add(Locale.ENGLISH, structuredContent);
    webpage.setText(localizedStructuredContent);
    return webpage;
  }
}
