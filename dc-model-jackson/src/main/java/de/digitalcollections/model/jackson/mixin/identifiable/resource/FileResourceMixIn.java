package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.impl.identifiable.resource.ApplicationFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.AudioFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.ImageFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.TextFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.VideoFileResourceImpl;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "fileresourceType",
        visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ApplicationFileResourceImpl.class, name = "application_fileresource"),
  @JsonSubTypes.Type(value = AudioFileResourceImpl.class, name = "audio_fileresource"),
  @JsonSubTypes.Type(value = ImageFileResourceImpl.class, name = "image_fileresource"),
  @JsonSubTypes.Type(value = TextFileResourceImpl.class, name = "text_fileresource"),
  @JsonSubTypes.Type(value = VideoFileResourceImpl.class, name = "video_fileresource")
})
public interface FileResourceMixIn {

}
