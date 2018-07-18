package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.BlockquoteImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.BulletListImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.CodeBlockImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HardBreakImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.HeadingImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.IFrameImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ListItemImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.OrderedListImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TextImpl;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = BlockquoteImpl.class, name = "blockquote"),
  @JsonSubTypes.Type(value = BulletListImpl.class, name = "bullet_list"),
  @JsonSubTypes.Type(value = CodeBlockImpl.class, name = "code_block"),
  @JsonSubTypes.Type(value = HardBreakImpl.class, name = "hard_break"),
  @JsonSubTypes.Type(value = HeadingImpl.class, name = "heading"),
  @JsonSubTypes.Type(value = IFrameImpl.class, name = "iframe"),
  @JsonSubTypes.Type(value = ListItemImpl.class, name = "list_item"),
  @JsonSubTypes.Type(value = OrderedListImpl.class, name = "ordered_list"),
  @JsonSubTypes.Type(value = ParagraphImpl.class, name = "paragraph"),
  @JsonSubTypes.Type(value = TextImpl.class, name = "text")
})
public interface ContentBlockMixIn {

  @JsonProperty("content")
  List<ContentBlock> getContents();

  @JsonProperty("content")
  void setContents(List<ContentBlock> contents);

  @JsonIgnore
  void addContent(ContentBlock content);

}
