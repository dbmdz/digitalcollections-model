package de.digitalcollections.model.jackson.mixin.identifiable.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.web.Webpage;

@JsonDeserialize(as = Webpage.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("webpage")
public interface WebpageMixIn {}
