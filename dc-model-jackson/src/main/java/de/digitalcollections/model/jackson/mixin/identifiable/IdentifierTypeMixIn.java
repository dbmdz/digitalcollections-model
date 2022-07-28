package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.IdentifierType;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;

@JsonDeserialize(as = IdentifierType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface IdentifierTypeMixIn extends UniqueObjectMixIn {}
