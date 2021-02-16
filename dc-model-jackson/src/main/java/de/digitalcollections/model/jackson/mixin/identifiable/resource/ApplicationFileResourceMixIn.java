package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.resource.ApplicationFileResource;

@JsonDeserialize(as = ApplicationFileResource.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ApplicationFileResourceMixIn {}
