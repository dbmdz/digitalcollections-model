package de.digitalcollections.model.jackson.mixin.identifiable.entity.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;

@JsonDeserialize(as = Person.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("person")
public interface PersonMixIn extends EntityMixIn {}
