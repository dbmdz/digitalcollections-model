package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.VideoImpl;

@JsonDeserialize(as = VideoImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface VideoMixIn extends AttributesMixIn {}
