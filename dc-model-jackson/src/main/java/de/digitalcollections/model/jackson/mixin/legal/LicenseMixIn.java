package de.digitalcollections.model.jackson.mixin.legal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.legal.LicenseImpl;

@JsonDeserialize(as = LicenseImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LicenseMixIn {}
