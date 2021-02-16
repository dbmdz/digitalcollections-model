package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;

@JsonDeserialize(as = ImageFileResource.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ImageFileResourceMixIn {}
