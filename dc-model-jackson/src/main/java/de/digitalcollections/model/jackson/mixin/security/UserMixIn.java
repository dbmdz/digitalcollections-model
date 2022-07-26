package de.digitalcollections.model.jackson.mixin.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;
import de.digitalcollections.model.security.User;

@JsonDeserialize(as = User.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface UserMixIn extends UniqueObjectMixIn {}
