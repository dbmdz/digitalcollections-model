package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import java.util.List;

public interface ContentBlockNodeMixin {

  @JsonProperty("content")
  List<ContentBlock> getContentBlocks();

  @JsonProperty("content")
  void setContentBlocks(List<ContentBlock> contentBlocks);

  @JsonIgnore
  void addContentBlock(ContentBlock contentBlock);
}
