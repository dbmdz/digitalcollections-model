package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.IFrameImpl;

@JsonDeserialize(as = IFrameImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface IFrameMixIn extends AttributesMixIn {

}
