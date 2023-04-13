package de.digitalcollections.model.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "objectType", visible = true)
// @JsonSubTypes({
//  @JsonSubTypes.Type(value = Headword.class, name = "HEADWORD"),
//  @JsonSubTypes.Type(value = Identifiable.class, name = "IDENTIFIABLE"),
//  @JsonSubTypes.Type(value = Identifier.class, name = "IDENTIFIER"),
//  @JsonSubTypes.Type(value = IdentifierType.class, name = "IDENTIFIER_TYPE"),
//  @JsonSubTypes.Type(value = License.class, name = "LICENSE"),
//  @JsonSubTypes.Type(value = Predicate.class, name = "PREDICATE"),
//  @JsonSubTypes.Type(value = RenderingTemplate.class, name = "RENDERING_TEMPLATE"),
//  @JsonSubTypes.Type(value = User.class, name = "USER")
// })
@JsonInclude(value = Include.NON_EMPTY)
public interface UniqueObjectMixIn {}
