package de.digitalcollections.model.jackson.mixin.text.contentblock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.text.contentblock.ListItem;

@JsonDeserialize(as = ListItem.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ListItemMixIn extends ContentBlockNodeMixin {}
