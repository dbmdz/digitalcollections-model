package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.work.Involvement;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;

@JsonDeserialize(as = Involvement.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("INVOLVEMENT")
public interface InvolvementMixIn extends UniqueObjectMixIn {}
