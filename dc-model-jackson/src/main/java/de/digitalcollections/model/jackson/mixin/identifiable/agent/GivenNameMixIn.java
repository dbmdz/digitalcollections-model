package de.digitalcollections.model.jackson.mixin.identifiable.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.agent.GivenNameImpl;

@JsonDeserialize(as = GivenNameImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("GIVEN_NAME")
public interface GivenNameMixIn {}
