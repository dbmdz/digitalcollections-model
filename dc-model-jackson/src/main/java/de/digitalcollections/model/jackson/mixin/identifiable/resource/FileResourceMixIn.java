package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.impl.identifiable.resource.ApplicationFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.AudioFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.FileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.ImageFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.LinkedDataFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.TextFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.VideoFileResourceImpl;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "fileResourceType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ApplicationFileResourceImpl.class, name = "APPLICATION"),
  @JsonSubTypes.Type(value = AudioFileResourceImpl.class, name = "AUDIO"),
  @JsonSubTypes.Type(value = FileResourceImpl.class, name = "UNDEFINED"),
  @JsonSubTypes.Type(value = ImageFileResourceImpl.class, name = "IMAGE"),
  @JsonSubTypes.Type(value = LinkedDataFileResourceImpl.class, name = "LINKED_DATA"),
  @JsonSubTypes.Type(value = TextFileResourceImpl.class, name = "TEXT"),
  @JsonSubTypes.Type(value = VideoFileResourceImpl.class, name = "VIDEO")
})
public interface FileResourceMixIn {}
