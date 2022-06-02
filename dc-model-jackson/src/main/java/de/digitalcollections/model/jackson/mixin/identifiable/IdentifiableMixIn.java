package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.agent.FamilyName;
import de.digitalcollections.model.identifiable.agent.GivenName;
import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.Collection;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.HeadwordEntry;
import de.digitalcollections.model.identifiable.entity.Project;
import de.digitalcollections.model.identifiable.entity.Topic;
import de.digitalcollections.model.identifiable.entity.Website;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.identifiable.entity.agent.Family;
import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.identifiable.entity.geo.location.Canyon;
import de.digitalcollections.model.identifiable.entity.geo.location.Cave;
import de.digitalcollections.model.identifiable.entity.geo.location.Continent;
import de.digitalcollections.model.identifiable.entity.geo.location.Country;
import de.digitalcollections.model.identifiable.entity.geo.location.Creek;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import de.digitalcollections.model.identifiable.entity.geo.location.Lake;
import de.digitalcollections.model.identifiable.entity.geo.location.Mountain;
import de.digitalcollections.model.identifiable.entity.geo.location.Ocean;
import de.digitalcollections.model.identifiable.entity.geo.location.River;
import de.digitalcollections.model.identifiable.entity.geo.location.Sea;
import de.digitalcollections.model.identifiable.entity.geo.location.StillWaters;
import de.digitalcollections.model.identifiable.entity.geo.location.Valley;
import de.digitalcollections.model.identifiable.entity.work.Expression;
import de.digitalcollections.model.identifiable.entity.work.Item;
import de.digitalcollections.model.identifiable.entity.work.Manifestation;
import de.digitalcollections.model.identifiable.entity.work.Work;
import de.digitalcollections.model.identifiable.resource.ApplicationFileResource;
import de.digitalcollections.model.identifiable.resource.AudioFileResource;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.identifiable.resource.LinkedDataFileResource;
import de.digitalcollections.model.identifiable.resource.TextFileResource;
import de.digitalcollections.model.identifiable.resource.VideoFileResource;
import de.digitalcollections.model.identifiable.web.Webpage;
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
  @JsonSubTypes.Type(value = Agent.class, name = "AGENT"),
  @JsonSubTypes.Type(value = ApplicationFileResource.class, name = "APPLICATION_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Article.class, name = "ARTICLE"),
  @JsonSubTypes.Type(value = AudioFileResource.class, name = "AUDIO_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Canyon.class, name = "CANYON"),
  @JsonSubTypes.Type(value = Cave.class, name = "CAVE"),
  @JsonSubTypes.Type(value = Collection.class, name = "COLLECTION"),
  @JsonSubTypes.Type(value = Continent.class, name = "CONTINENT"),
  @JsonSubTypes.Type(value = CorporateBody.class, name = "CORPORATE_BODY"),
  @JsonSubTypes.Type(value = Country.class, name = "COUNTRY"),
  @JsonSubTypes.Type(value = Creek.class, name = "CREEK"),
  @JsonSubTypes.Type(value = DigitalObject.class, name = "DIGITAL_OBJECT"),
  @JsonSubTypes.Type(value = Entity.class, name = "ENTITY"),
  @JsonSubTypes.Type(value = Expression.class, name = "EXPRESSION"),
  @JsonSubTypes.Type(value = Family.class, name = "FAMILY"),
  @JsonSubTypes.Type(value = FamilyName.class, name = "FAMILY_NAME"),
  @JsonSubTypes.Type(value = GeoLocation.class, name = "GEOLOCATION"),
  @JsonSubTypes.Type(value = GivenName.class, name = "GIVEN_NAME"),
  @JsonSubTypes.Type(value = HeadwordEntry.class, name = "HEADWORD_ENTRY"),
  @JsonSubTypes.Type(value = Identifiable.class, name = "IDENFITIABLE"),
  @JsonSubTypes.Type(value = ImageFileResource.class, name = "IMAGE_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Item.class, name = "ITEM"),
  @JsonSubTypes.Type(value = Lake.class, name = "LAKE"),
  @JsonSubTypes.Type(value = LinkedDataFileResource.class, name = "LINKED_DATA_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Manifestation.class, name = "MANIFESTATION"),
  @JsonSubTypes.Type(value = Mountain.class, name = "MOUNTAIN"),
  @JsonSubTypes.Type(value = Ocean.class, name = "OCEAN"),
  @JsonSubTypes.Type(value = Person.class, name = "PERSON"),
  @JsonSubTypes.Type(value = Project.class, name = "PROJECT"),
  @JsonSubTypes.Type(value = River.class, name = "RIVER"),
  @JsonSubTypes.Type(value = Sea.class, name = "SEA"),
  @JsonSubTypes.Type(value = StillWaters.class, name = "STILL_WATERS"),
  @JsonSubTypes.Type(value = TextFileResource.class, name = "TEXT_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Topic.class, name = "TOPIC"),
  @JsonSubTypes.Type(value = Valley.class, name = "VALLEY"),
  @JsonSubTypes.Type(value = VideoFileResource.class, name = "VIDEO_FILE_RESOURCE"),
  @JsonSubTypes.Type(value = Webpage.class, name = "WEBPAGE"),
  @JsonSubTypes.Type(value = Website.class, name = "WEBSITE"),
  @JsonSubTypes.Type(value = Work.class, name = "WORK")
})
public interface IdentifiableMixIn {

  @JsonSetter
  public void setLabel(LocalizedText label);
}
