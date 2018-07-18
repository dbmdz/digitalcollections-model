package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.BulletListImpl;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.ContentBlockNodeMixin;

@JsonDeserialize(as = BulletListImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface BulletListMixIn extends ContentBlockNodeMixin {

}
