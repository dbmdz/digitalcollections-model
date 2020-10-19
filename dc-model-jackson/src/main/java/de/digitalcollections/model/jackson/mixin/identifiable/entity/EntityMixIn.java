package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.impl.identifiable.entity.ArticleImpl;
import de.digitalcollections.model.impl.identifiable.entity.CollectionImpl;
import de.digitalcollections.model.impl.identifiable.entity.DigitalObjectImpl;
import de.digitalcollections.model.impl.identifiable.entity.ProjectImpl;
import de.digitalcollections.model.impl.identifiable.entity.TopicImpl;
import de.digitalcollections.model.impl.identifiable.entity.WebsiteImpl;
import de.digitalcollections.model.impl.identifiable.entity.agent.PersonImpl;
import de.digitalcollections.model.impl.identifiable.entity.work.ExpressionImpl;
import de.digitalcollections.model.impl.identifiable.entity.work.ItemImpl;
import de.digitalcollections.model.impl.identifiable.entity.work.ManifestationImpl;
import de.digitalcollections.model.impl.identifiable.entity.work.WorkImpl;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "entityType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  // need to be uppercase (and included as EXISTING_PROPERTY) to reuse enum field values (see
  // EntityType) for deserializing:
  @JsonSubTypes.Type(value = ArticleImpl.class, name = "ARTICLE"),
  @JsonSubTypes.Type(value = CollectionImpl.class, name = "COLLECTION"),
  @JsonSubTypes.Type(value = DigitalObjectImpl.class, name = "DIGITAL_OBJECT"),
  @JsonSubTypes.Type(value = ExpressionImpl.class, name = "EXPRESSION"),
  //  @JsonSubTypes.Type(value = GeoLocationImpl.class, name = "GEOLOCATION"),
  @JsonSubTypes.Type(value = ItemImpl.class, name = "ITEM"),
  @JsonSubTypes.Type(value = ManifestationImpl.class, name = "MANIFESTATION"),
  @JsonSubTypes.Type(value = PersonImpl.class, name = "PERSON"),
  @JsonSubTypes.Type(value = ProjectImpl.class, name = "PROJECT"),
  @JsonSubTypes.Type(value = TopicImpl.class, name = "TOPIC"),
  @JsonSubTypes.Type(value = WebsiteImpl.class, name = "WEBSITE"),
  @JsonSubTypes.Type(value = WorkImpl.class, name = "WORK")
})
public interface EntityMixIn {}
