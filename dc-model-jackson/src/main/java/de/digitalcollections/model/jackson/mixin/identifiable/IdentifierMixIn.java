package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.IdentifierImpl;

@JsonDeserialize(as = IdentifierImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("identifier")
public interface IdentifierMixIn {}
