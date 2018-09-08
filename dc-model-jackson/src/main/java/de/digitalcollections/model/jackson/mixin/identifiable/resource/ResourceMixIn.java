package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.resource.ResourceImpl;

@JsonDeserialize(as = ResourceImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("resource")
public interface ResourceMixIn {

}
