package de.digitalcollections.model.xml.xstream.v1;

import com.thoughtworks.xstream.XStream;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.impl.identifiable.entity.parts.WebpageImpl;
import de.digitalcollections.model.impl.identifiable.parts.TranslationImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.BlockquoteImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.BulletListImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.CodeBlockImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HardBreakImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HeadingImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.IFrameImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ListItemImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.MarkImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.OrderedListImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import de.digitalcollections.model.impl.identifiable.resource.FileResourceImpl;
import de.digitalcollections.model.xml.xstream.CdataXppDriver;
import de.digitalcollections.model.xml.xstream.MapToFlatConverter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.oxm.xstream.XStreamMarshaller;

public class V1DigitalCollectionsXStreamMarshaller extends XStreamMarshaller {

  public V1DigitalCollectionsXStreamMarshaller() {
    super();

    setStreamDriver(new CdataXppDriver());

    Map<String, Class> aliases = getAliases();
    setAliases(aliases);

    Map<Class, String> attributes = new HashMap<>();
    attributes.put(MarkImpl.class, "type");
    setUseAttributeFor(attributes);

    XStream xStream = getXStream();
    xStream.aliasSystemAttribute(null, "class");

    xStream.registerConverter(new MapToFlatConverter(xStream.getMapper()));
    xStream.aliasField("body", TextImpl.class, "text");
    xStream.aliasField("content", BlockquoteImpl.class, "contentBlocks");
    xStream.aliasField("content", BulletListImpl.class, "contentBlocks");
    xStream.aliasField("content", CodeBlockImpl.class, "contentBlocks");
    xStream.aliasField("content", HeadingImpl.class, "contentBlocks");
    xStream.aliasField("content", ListItemImpl.class, "contentBlocks");
    xStream.aliasField("content", OrderedListImpl.class, "contentBlocks");
    xStream.aliasField("content", ParagraphImpl.class, "contentBlocks");
    xStream.aliasField("content", StructuredContentImpl.class, "contentBlocks");
    xStream.aliasField("documents", LocalizedStructuredContentImpl.class, "localizedStructuredContent");
    xStream.setMode(XStream.NO_REFERENCES);
  }

  protected Map<String, Class> getAliases() {
    Map<String, Class> aliases = new HashMap<>();
    aliases.put("blockquote", BlockquoteImpl.class);
    aliases.put("bulletList", BulletListImpl.class);
    aliases.put("codeBlock", CodeBlockImpl.class);
    aliases.put("content", ContentBlock.class);
    aliases.put("fileresource", FileResourceImpl.class);
    aliases.put("hardBreak", HardBreakImpl.class);
    aliases.put("heading", HeadingImpl.class);
    aliases.put("iframe", IFrameImpl.class);
    aliases.put("listItem", ListItemImpl.class);
    aliases.put("documents", LocalizedStructuredContentImpl.class);
    aliases.put("mark", MarkImpl.class);
    aliases.put("orderedList", OrderedListImpl.class);
    aliases.put("paragraph", ParagraphImpl.class);
    aliases.put("document", StructuredContentImpl.class);
    aliases.put("text", TextImpl.class);
    aliases.put("translation", TranslationImpl.class);
    aliases.put("webpage", WebpageImpl.class);
    return aliases;
  }
}
