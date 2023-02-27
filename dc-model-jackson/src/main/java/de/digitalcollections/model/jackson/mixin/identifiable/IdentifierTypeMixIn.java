package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.IdentifierType;

@JsonDeserialize(as = IdentifierType.class)
public interface IdentifierTypeMixIn extends UniqueObjectMixIn {}
