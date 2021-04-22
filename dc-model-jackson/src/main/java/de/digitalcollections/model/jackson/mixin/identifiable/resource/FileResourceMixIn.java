package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import de.digitalcollections.model.identifiable.resource.ApplicationFileResource;
import de.digitalcollections.model.identifiable.resource.AudioFileResource;
import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.identifiable.resource.TextFileResource;
import de.digitalcollections.model.identifiable.resource.VideoFileResource;
import de.digitalcollections.model.jackson.mixin.identifiable.IdentifiableMixIn;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.WRAPPER_OBJECT,
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ApplicationFileResource.class, name = "application"),
  @JsonSubTypes.Type(value = AudioFileResource.class, name = "audio"),
  @JsonSubTypes.Type(value = FileResource.class, name = "undefined"),
  @JsonSubTypes.Type(value = ImageFileResource.class, name = "image"),
  @JsonSubTypes.Type(value = LinkedDataFileResource.class, name = "linkedData"),
  @JsonSubTypes.Type(value = TextFileResource.class, name = "text"),
  @JsonSubTypes.Type(value = VideoFileResource.class, name = "video")
})
public interface FileResourceMixIn extends IdentifiableMixIn {}
