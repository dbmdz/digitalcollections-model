package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.agent.FamilyName;
import de.digitalcollections.model.identifiable.agent.GivenName;
import de.digitalcollections.model.identifiable.entity.geo.location.Canyon;
import de.digitalcollections.model.identifiable.entity.geo.location.Cave;
import de.digitalcollections.model.identifiable.entity.geo.location.Continent;
import de.digitalcollections.model.identifiable.entity.geo.location.Country;
import de.digitalcollections.model.identifiable.entity.geo.location.Creek;
import de.digitalcollections.model.identifiable.entity.geo.location.Lake;
import de.digitalcollections.model.identifiable.entity.geo.location.Mountain;
import de.digitalcollections.model.identifiable.entity.geo.location.Ocean;
import de.digitalcollections.model.identifiable.entity.geo.location.River;
import de.digitalcollections.model.identifiable.entity.geo.location.Sea;
import de.digitalcollections.model.identifiable.entity.geo.location.StillWaters;
import de.digitalcollections.model.identifiable.entity.geo.location.Valley;
import de.digitalcollections.model.identifiable.resource.ApplicationFileResource;
import de.digitalcollections.model.identifiable.resource.AudioFileResource;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.identifiable.resource.TextFileResource;
import de.digitalcollections.model.identifiable.resource.VideoFileResource;
import de.digitalcollections.model.identifiable.web.Webpage;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;
import de.digitalcollections.model.text.LocalizedText;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "identifiableObjectType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  // need to be uppercase (and included as EXISTING_PROPERTY) to reuse enum field values (see
  // IdentifiableObjectType) for deserializing:
  @JsonSubTypes.Type(value = ApplicationFileResource.class, name = "APPLICATION_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = AudioFileResource.class, name = "AUDIO_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Canyon.class, name = "CANYON"),
  @JsonSubTypes.Type(value = Cave.class, name = "CAVE"),
  @JsonSubTypes.Type(value = Continent.class, name = "CONTINENT"),
  @JsonSubTypes.Type(value = Country.class, name = "COUNTRY"),
  @JsonSubTypes.Type(value = Creek.class, name = "CREEK"),
  @JsonSubTypes.Type(value = FamilyName.class, name = "FAMILY_NAME"),
  @JsonSubTypes.Type(value = GivenName.class, name = "GIVEN_NAME"),
  @JsonSubTypes.Type(value = Identifiable.class, name = "IDENTIFIABLE"),
  @JsonSubTypes.Type(value = Identifiable.class, name = "IDENFITIABLE"),
  @JsonSubTypes.Type(value = ImageFileResource.class, name = "IMAGE_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Lake.class, name = "LAKE"),
  @JsonSubTypes.Type(value = LinkedDataFileResource.class, name = "LINKED_DATA_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Mountain.class, name = "MOUNTAIN"),
  @JsonSubTypes.Type(value = Ocean.class, name = "OCEAN"),
  @JsonSubTypes.Type(value = River.class, name = "RIVER"),
  @JsonSubTypes.Type(value = Sea.class, name = "SEA"),
  @JsonSubTypes.Type(value = StillWaters.class, name = "STILL_WATERS"),
  @JsonSubTypes.Type(value = TextFileResource.class, name = "TEXT_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Valley.class, name = "VALLEY"),
  @JsonSubTypes.Type(value = VideoFileResource.class, name = "VIDEO_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Webpage.class, name = "WEBPAGE")
})
public interface IdentifiableMixIn extends UniqueObjectMixIn {

  @JsonSetter
  public void setLabel(LocalizedText label);
}
