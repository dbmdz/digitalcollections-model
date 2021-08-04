package de.digitalcollections.model.jackson.mixin.alias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.alias.UrlAlias;

@JsonDeserialize(as = UrlAlias.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface UrlAliasMixIn {}
