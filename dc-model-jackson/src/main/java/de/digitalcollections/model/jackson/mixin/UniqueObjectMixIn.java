package de.digitalcollections.model.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.IdentifierType;
import de.digitalcollections.model.identifiable.entity.manifestation.Publisher;
import de.digitalcollections.model.legal.License;
import de.digitalcollections.model.relation.Predicate;
import de.digitalcollections.model.security.User;
import de.digitalcollections.model.semantic.Headword;
import de.digitalcollections.model.semantic.Subject;
import de.digitalcollections.model.semantic.Tag;
import de.digitalcollections.model.view.RenderingTemplate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "objectType", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Headword.class, name = "HEADWORD"),
  @JsonSubTypes.Type(value = Identifiable.class, name = "IDENTIFIABLE"),
  @JsonSubTypes.Type(value = Identifier.class, name = "IDENTIFIER"),
  @JsonSubTypes.Type(value = IdentifierType.class, name = "IDENTIFIER_TYPE"),
  @JsonSubTypes.Type(value = License.class, name = "LICENSE"),
  @JsonSubTypes.Type(value = Predicate.class, name = "PREDICATE"),
  @JsonSubTypes.Type(value = Publisher.class, name = "PUBLISHER"),
  @JsonSubTypes.Type(value = RenderingTemplate.class, name = "RENDERING_TEMPLATE"),
  @JsonSubTypes.Type(value = Subject.class, name = "SUBJECT"),
  @JsonSubTypes.Type(value = Tag.class, name = "TAG"),
  @JsonSubTypes.Type(value = User.class, name = "USER")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public interface UniqueObjectMixIn {}
