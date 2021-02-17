package de.digitalcollections.model.jackson.mixin.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.security.User;

@JsonDeserialize(as = User.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("USER")
// @JsonTypeInfo(use = Id.NAME, include = As.PROPERTY)
// @JsonSubTypes({@JsonSubTypes.Type(value = User.class)})
public interface UserMixIn {}
