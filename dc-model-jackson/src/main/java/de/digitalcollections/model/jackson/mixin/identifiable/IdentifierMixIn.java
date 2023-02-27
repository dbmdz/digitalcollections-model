package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.Identifier;

@JsonDeserialize(as = Identifier.class)
public interface IdentifierMixIn extends UniqueObjectMixIn {}
