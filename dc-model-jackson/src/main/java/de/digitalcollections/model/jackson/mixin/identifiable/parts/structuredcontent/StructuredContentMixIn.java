package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import java.util.List;

@JsonDeserialize(as = StructuredContentImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true)
@JsonTypeName("doc")
public interface StructuredContentMixIn {

  @JsonProperty("content")
  public List<ContentBlock> getContentBlocks();

}
