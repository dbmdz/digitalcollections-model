package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ImageImpl;

@JsonDeserialize(as = ImageImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ImageMixIn extends AttributesMixIn {}
