package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.Collection;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.Project;
import de.digitalcollections.model.identifiable.entity.Topic;
import de.digitalcollections.model.identifiable.entity.Website;
import de.digitalcollections.model.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.identifiable.entity.agent.Family;
import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import de.digitalcollections.model.identifiable.entity.work.Expression;
import de.digitalcollections.model.identifiable.entity.work.Item;
import de.digitalcollections.model.identifiable.entity.work.Manifestation;
import de.digitalcollections.model.identifiable.entity.work.Work;
import de.digitalcollections.model.jackson.mixin.identifiable.IdentifiableMixIn;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.WRAPPER_OBJECT,
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Article.class, name = "article"),
  @JsonSubTypes.Type(value = Collection.class, name = "collection"),
  @JsonSubTypes.Type(value = CorporateBody.class, name = "corporateBody"),
  @JsonSubTypes.Type(value = DigitalObject.class, name = "digitalObject"),
  @JsonSubTypes.Type(value = Entity.class, name = "entity"),
  @JsonSubTypes.Type(value = Expression.class, name = "expression"),
  @JsonSubTypes.Type(value = Family.class, name = "family"),
  @JsonSubTypes.Type(value = GeoLocation.class, name = "geoLocation"),
  @JsonSubTypes.Type(value = Item.class, name = "item"),
  @JsonSubTypes.Type(value = Manifestation.class, name = "manifestation"),
  @JsonSubTypes.Type(value = Person.class, name = "person"),
  @JsonSubTypes.Type(value = Project.class, name = "project"),
  @JsonSubTypes.Type(value = Topic.class, name = "topic"),
  @JsonSubTypes.Type(value = Website.class, name = "website"),
  @JsonSubTypes.Type(value = Work.class, name = "work")
})
public interface EntityMixIn extends IdentifiableMixIn {}
