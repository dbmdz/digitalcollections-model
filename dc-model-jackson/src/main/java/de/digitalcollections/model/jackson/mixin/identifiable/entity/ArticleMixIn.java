package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.Article;

@JsonDeserialize(as = Article.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ARTICLE")
public interface ArticleMixIn extends EntityMixIn {}
