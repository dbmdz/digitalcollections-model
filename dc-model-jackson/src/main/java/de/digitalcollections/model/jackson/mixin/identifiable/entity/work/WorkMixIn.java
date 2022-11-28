package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.manifestation.Series;
import de.digitalcollections.model.identifiable.entity.work.Work;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;

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
@JsonDeserialize(as = Work.class)
@JsonTypeName("WORK")
public interface WorkMixIn extends EntityMixIn {}
