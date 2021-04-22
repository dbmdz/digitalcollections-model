package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifierType;
import de.digitalcollections.model.identifiable.agent.FamilyName;
import de.digitalcollections.model.identifiable.agent.GivenName;
import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.Collection;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.Project;
import de.digitalcollections.model.identifiable.entity.Topic;
import de.digitalcollections.model.identifiable.entity.Website;
import de.digitalcollections.model.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.identifiable.entity.relation.EntityRelation;
import de.digitalcollections.model.identifiable.entity.work.Item;
import de.digitalcollections.model.identifiable.entity.work.Work;
import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.web.Webpage;
import de.digitalcollections.model.paging.PageResponse;
import de.digitalcollections.model.paging.Sorting;
import de.digitalcollections.model.security.User;
import de.digitalcollections.model.view.RenderingTemplate;
import java.util.List;

@JsonDeserialize(as = PageResponse.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PageResponseMixIn<T> extends PageResponse<T> {

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      include = As.WRAPPER_OBJECT,
      visible = true)
  @JsonSubTypes({
      @Type(value = Article.class, name = "article"),
      @Type(value = Collection.class, name = "collection"),
      @Type(value = CorporateBody.class, name = "corporateBody"),
      @Type(value = DigitalObject.class, name = "digitalObject"),
      @Type(value = Entity.class, name = "entity"),
      @Type(value = EntityRelation.class, name = "entityRelation"),
      @Type(value = FamilyName.class, name = "familyName"),
      @Type(value = FileResource.class, name = "fileResource"),
      @Type(value = GeoLocation.class, name = "geoLocation"),
      @Type(value = GivenName.class, name = "givenName"),
      @Type(value = HumanSettlement.class, name = "humanSettlement"),
      @Type(value = Identifiable.class, name = "identifiable"),
      @Type(value = IdentifierType.class, name = "identifierType"),
      @Type(value = Item.class, name = "item"),
      @Type(value = Person.class, name = "person"),
      @Type(value = Project.class, name = "project"),
      @Type(value = RenderingTemplate.class, name = "renderingTemplate"),
      @Type(value = Topic.class, name = "topic"),
      @Type(value = User.class, name = "user"),
      @Type(value = Webpage.class, name = "webpage"),
      @Type(value = Website.class, name = "website"),
      @Type(value = Work.class, name = "work")
  })
  @Override
  public abstract List<T> getContent();

  @JsonIgnore
  @Override
  public abstract int getNumber();

  @JsonIgnore
  @Override
  public abstract int getNumberOfElements();

  @JsonIgnore
  @Override
  public abstract int getSize();

  @JsonIgnore
  @Override
  public abstract Sorting getSorting();

  @JsonIgnore
  @Override
  public abstract int getTotalPages();

  @JsonIgnore
  @Override
  public abstract boolean isFirst();

  @JsonIgnore
  @Override
  public abstract boolean isLast();
}
