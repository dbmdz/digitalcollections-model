package de.digitalcollections.model.jackson.mixin.identifiable.alias;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.alias.UrlAlias;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;

@JsonDeserialize(as = UrlAlias.class)
@JsonTypeName("URL_ALIAS")
public interface UrlAliasMixIn extends UniqueObjectMixIn {}
