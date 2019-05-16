package de.digitalcollections.model.jackson.mixin.identifiable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.IdentifierTypeImpl;

@JsonDeserialize(as = IdentifierTypeImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("identifier")
public interface IdentifierTypeMixIn {

}
