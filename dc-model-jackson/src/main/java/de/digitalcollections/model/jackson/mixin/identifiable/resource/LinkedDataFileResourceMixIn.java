package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.resource.LinkedDataFileResource;

@JsonDeserialize(as = LinkedDataFileResource.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LinkedDataFileResourceMixIn {}
