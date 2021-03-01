package de.digitalcollections.model.jackson.mixin.text.contentblock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.text.contentblock.Blockquote;

@JsonDeserialize(as = Blockquote.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface BlockquoteMixIn extends ContentBlockNodeMixin {}
