package de.digitalcollections.model.jackson.mixin.identifiable.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.agent.GivenName;
import de.digitalcollections.model.jackson.mixin.identifiable.IdentifiableMixIn;

@JsonDeserialize(as = GivenName.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("givenName")
public interface GivenNameMixIn extends IdentifiableMixIn {}
