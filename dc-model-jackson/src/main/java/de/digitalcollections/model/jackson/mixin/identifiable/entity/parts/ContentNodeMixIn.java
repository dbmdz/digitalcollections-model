package de.digitalcollections.model.jackson.mixin.identifiable.entity.parts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.parts.ContentNodeImpl;

@JsonDeserialize(as = ContentNodeImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("contentNode")
public interface ContentNodeMixIn {}
