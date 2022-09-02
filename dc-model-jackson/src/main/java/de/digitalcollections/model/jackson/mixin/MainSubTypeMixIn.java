package de.digitalcollections.model.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.MainSubType;

@JsonDeserialize(as = MainSubType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface MainSubTypeMixIn {}
