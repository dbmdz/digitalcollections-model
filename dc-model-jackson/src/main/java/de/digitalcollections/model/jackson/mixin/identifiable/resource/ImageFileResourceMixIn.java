package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.resource.ImageFileResourceImpl;

@JsonDeserialize(as = ImageFileResourceImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ImageFileResourceMixIn {}
