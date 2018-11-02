package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.resource.TextFileResourceImpl;

@JsonDeserialize(as = TextFileResourceImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("textfileresource")
public interface TextFileResourceMixIn {

}
