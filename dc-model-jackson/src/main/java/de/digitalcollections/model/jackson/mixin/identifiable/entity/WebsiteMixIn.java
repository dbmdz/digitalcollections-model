package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.Website;

@JsonDeserialize(as = Website.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("WEBSITE")
public interface WebsiteMixIn {}
