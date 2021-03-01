package de.digitalcollections.model.jackson.mixin.text.contentblock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.text.contentblock.TableCell;

@JsonDeserialize(as = TableCell.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface TableCellMixIn extends ContentBlockNodeMixin, ContentBlockWithAttributesMixIn {}
