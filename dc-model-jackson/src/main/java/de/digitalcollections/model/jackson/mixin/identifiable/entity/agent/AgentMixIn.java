package de.digitalcollections.model.jackson.mixin.identifiable.entity.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.identifiable.entity.agent.Family;
import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.WRAPPER_OBJECT,
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Agent.class, name = "agent"),
  @JsonSubTypes.Type(value = CorporateBody.class, name = "corporateBody"),
  @JsonSubTypes.Type(value = Family.class, name = "family"),
  @JsonSubTypes.Type(value = Person.class, name = "person")
})
public interface AgentMixIn extends EntityMixIn {}
