package de.digitalcollections.model.jackson.mixin.identifiable.entity.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.impl.identifiable.entity.agent.CorporateBodyImpl;
import de.digitalcollections.model.impl.identifiable.entity.agent.FamilyImpl;
import de.digitalcollections.model.impl.identifiable.entity.agent.PersonImpl;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "entityType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  // need to be uppercase (and included as EXISTING_PROPERTY) to reuse enum field values for
  // deserializing:
  @JsonSubTypes.Type(value = CorporateBodyImpl.class, name = "CORPORATE_BODY"),
  @JsonSubTypes.Type(value = FamilyImpl.class, name = "FAMILY"),
  @JsonSubTypes.Type(value = PersonImpl.class, name = "PERSON")
})
public interface AgentMixIn {}
