package de.digitalcollections.model.jackson.mixin.list;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
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
import de.digitalcollections.model.identifiable.entity.item.Item;
import de.digitalcollections.model.identifiable.entity.manifestation.Publisher;
import de.digitalcollections.model.identifiable.entity.relation.EntityRelation;
import de.digitalcollections.model.identifiable.entity.work.Work;
import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.web.Webpage;
import de.digitalcollections.model.list.ListRequest;
import de.digitalcollections.model.list.ListResponse;
import de.digitalcollections.model.list.buckets.BucketObjectsResponse;
import de.digitalcollections.model.list.buckets.BucketsResponse;
import de.digitalcollections.model.list.paging.PageResponse;
import de.digitalcollections.model.list.sorting.Sorting;
import de.digitalcollections.model.security.User;
import de.digitalcollections.model.semantic.Headword;
import de.digitalcollections.model.semantic.Subject;
import de.digitalcollections.model.semantic.Tag;
import de.digitalcollections.model.view.RenderingTemplate;
import java.util.List;

@JsonDeserialize(as = ListResponse.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "listResponseType", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = BucketObjectsResponse.class, name = "BUCKET_OBJECTS_RESPONSE"),
  @JsonSubTypes.Type(value = BucketsResponse.class, name = "BUCKETS_RESPONSE"),
  @JsonSubTypes.Type(value = ListResponse.class, name = "LIST_RESPONSE"),
  @JsonSubTypes.Type(value = PageResponse.class, name = "PAGE_RESPONSE"),
})
public abstract class ListResponseMixIn<T, R extends ListRequest> extends ListResponse<T, R> {

  @JsonTypeInfo(use = Id.NAME, property = "objectType", visible = true)
  @JsonSubTypes({
    @Type(value = Article.class, name = "ARTICLE"),
    @Type(value = Collection.class, name = "COLLECTION"),
    @Type(value = CorporateBody.class, name = "CORPORATE_BODY"),
    @Type(value = DigitalObject.class, name = "DIGITAL_OBJECT"),
    @Type(value = Entity.class, name = "ENTITY"),
    @Type(value = EntityRelation.class, name = "ENTITY_RELATION"),
    @Type(value = FamilyName.class, name = "FAMILY_NAME"),
    @Type(value = FileResource.class, name = "FILE_RESOURCE"),
    @Type(value = GeoLocation.class, name = "GEO_LOCATION"),
    @Type(value = GivenName.class, name = "GIVEN_NAME"),
    @Type(value = Headword.class, name = "HEADWORD"),
    @Type(value = HumanSettlement.class, name = "HUMAN_SETTLEMENT"),
    @Type(value = Identifiable.class, name = "IDENTIFIABLE"),
    @Type(value = IdentifierType.class, name = "IDENTIFIER_TYPE"),
    @Type(value = Item.class, name = "ITEM"),
    @Type(value = Person.class, name = "PERSON"),
    @Type(value = Publisher.class, name = "PUBLISHER"),
    @Type(value = Project.class, name = "PROJECT"),
    @Type(value = RenderingTemplate.class, name = "RENDERING_TEMPLATE"),
    @Type(value = Subject.class, name = "SUBJECT"),
    @Type(value = Tag.class, name = "TAG"),
    @Type(value = Topic.class, name = "TOPIC"),
    @Type(value = User.class, name = "USER"),
    @Type(value = Webpage.class, name = "WEBPAGE"),
    @Type(value = Website.class, name = "WEBSITE"),
    @Type(value = Work.class, name = "WORK")
  })
  @Override
  public abstract List<T> getContent();

  @JsonIgnore
  @Override
  public abstract Sorting getSorting();
}
