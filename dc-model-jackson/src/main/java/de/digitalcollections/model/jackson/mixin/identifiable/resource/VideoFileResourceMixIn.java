package de.digitalcollections.model.jackson.mixin.identifiable.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.resource.VideoFileResourceImpl;

@JsonDeserialize(as = VideoFileResourceImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface VideoFileResourceMixIn {}
