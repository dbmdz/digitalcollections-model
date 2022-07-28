package de.digitalcollections.model.jackson.mixin.legal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;
import de.digitalcollections.model.legal.License;

@JsonDeserialize(as = License.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LicenseMixIn extends UniqueObjectMixIn {}
