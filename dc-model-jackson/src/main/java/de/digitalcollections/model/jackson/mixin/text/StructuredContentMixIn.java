package de.digitalcollections.model.jackson.mixin.text;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.view.ToCEntry;
import java.util.List;

@JsonDeserialize(as = StructuredContent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.WRAPPER_OBJECT,
    visible = true)
@JsonTypeName("doc")
public interface StructuredContentMixIn {

  @JsonProperty("content")
  public List<ContentBlock> getContentBlocks();

  @JsonIgnore
  public List<ToCEntry> getTableOfContents();
}
