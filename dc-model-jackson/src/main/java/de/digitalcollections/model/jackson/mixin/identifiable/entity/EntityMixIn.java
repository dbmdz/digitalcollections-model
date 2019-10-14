package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.impl.identifiable.entity.ArticleImpl;
import de.digitalcollections.model.impl.identifiable.entity.CollectionImpl;
import de.digitalcollections.model.impl.identifiable.entity.ContentTreeImpl;
import de.digitalcollections.model.impl.identifiable.entity.DigitalObjectImpl;
import de.digitalcollections.model.impl.identifiable.entity.WebsiteImpl;

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
  @JsonSubTypes.Type(value = ContentTreeImpl.class, name = "CONTENT_TREE"),
  @JsonSubTypes.Type(value = DigitalObjectImpl.class, name = "DIGITAL_OBJECT"),
  @JsonSubTypes.Type(value = WebsiteImpl.class, name = "WEBSITE")
})
public interface EntityMixIn {}
