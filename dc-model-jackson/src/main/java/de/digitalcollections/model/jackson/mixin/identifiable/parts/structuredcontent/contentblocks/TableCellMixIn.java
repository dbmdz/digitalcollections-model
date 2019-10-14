package de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.contentblocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.TableCellImpl;
import de.digitalcollections.model.jackson.mixin.identifiable.parts.structuredcontent.ContentBlockNodeMixin;

@JsonDeserialize(as = TableCellImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface TableCellMixIn extends ContentBlockNodeMixin, AttributesMixIn {}
