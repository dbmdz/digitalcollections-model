package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.identifiable.resource.MimeType;
import de.digitalcollections.model.impl.identifiable.resource.FileResourceImpl;

@JsonDeserialize(as = FileResourceImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("fileresource")
public interface FileResourceMixIn {

  // FIXME: add MimeType mxin for deserializing with static factory methods in MimeType...
  @JsonIgnore
  public MimeType getMimeType();
}
