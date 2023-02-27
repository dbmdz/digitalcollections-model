package de.digitalcollections.model.jackson.mixin.identifiable.alias;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.alias.UrlAlias;

@JsonDeserialize(as = UrlAlias.class)
public interface UrlAliasMixIn {}
