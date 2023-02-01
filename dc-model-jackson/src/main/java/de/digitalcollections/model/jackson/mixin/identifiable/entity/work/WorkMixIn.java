package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.work.Work;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;

@JsonDeserialize(as = Work.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("WORK")
public interface WorkMixIn extends EntityMixIn {}
