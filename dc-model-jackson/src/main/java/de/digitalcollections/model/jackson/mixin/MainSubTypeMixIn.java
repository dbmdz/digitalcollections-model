package de.digitalcollections.model.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.MainSubType;
import de.digitalcollections.model.identifiable.entity.work.ExpressionType;
import de.digitalcollections.model.identifiable.entity.work.TitleType;

@JsonDeserialize(as = MainSubType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({
  @Type(value = TitleType.class, name = "TITLE_TYPE"),
  @Type(value = ExpressionType.class, name = "EXPRESSION_TYPE")
})
public interface MainSubTypeMixIn {}
