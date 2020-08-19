package de.digitalcollections.model.jackson.mixin.identifiable.entity.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.agent.PersonImpl;

@JsonDeserialize(as = PersonImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("PERSON")
public interface PersonMixIn {}
