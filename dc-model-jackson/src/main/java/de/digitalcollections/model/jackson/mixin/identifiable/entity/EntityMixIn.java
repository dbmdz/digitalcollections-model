package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.Collection;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.HeadwordEntry;
import de.digitalcollections.model.identifiable.entity.Project;
import de.digitalcollections.model.identifiable.entity.Topic;
import de.digitalcollections.model.identifiable.entity.Website;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import de.digitalcollections.model.identifiable.entity.work.Expression;
import de.digitalcollections.model.identifiable.entity.work.Item;
import de.digitalcollections.model.identifiable.entity.work.Manifestation;
import de.digitalcollections.model.identifiable.entity.work.Work;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "identifiableObjectType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  // need to be uppercase (and included as EXISTING_PROPERTY) to reuse enum field values (see
  // IdentifiableObjectType) for deserializing:
  @JsonSubTypes.Type(value = Article.class, name = "ARTICLE"),
  @JsonSubTypes.Type(value = Collection.class, name = "COLLECTION"),
  @JsonSubTypes.Type(value = DigitalObject.class, name = "DIGITAL_OBJECT"),
  @JsonSubTypes.Type(value = Entity.class, name = "ENTITY"),
  @JsonSubTypes.Type(value = Expression.class, name = "EXPRESSION"),
  @JsonSubTypes.Type(value = GeoLocation.class, name = "GEOLOCATION"),
  @JsonSubTypes.Type(value = HeadwordEntry.class, name = "HEADWORD_ENTRY"),
  @JsonSubTypes.Type(value = Item.class, name = "ITEM"),
  @JsonSubTypes.Type(value = Manifestation.class, name = "MANIFESTATION"),
  @JsonSubTypes.Type(value = Project.class, name = "PROJECT"),
  @JsonSubTypes.Type(value = Topic.class, name = "TOPIC"),
  @JsonSubTypes.Type(value = Website.class, name = "WEBSITE"),
  @JsonSubTypes.Type(value = Work.class, name = "WORK")
})
public interface EntityMixIn {}
