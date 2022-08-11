package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.digitalcollections.model.identifiable.entity.work.Series;
import de.digitalcollections.model.identifiable.entity.work.Work;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "workType",
    visible = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
  // need to be uppercase (and included as EXISTING_PROPERTY) to reuse enum field values (see
  // IdentifiableObjectType) for deserializing:
  @JsonSubTypes.Type(value = Series.class, name = "SERIES"),
  @JsonSubTypes.Type(value = Work.class, name = "SINGLE")
})
public interface WorkMixIn {}
