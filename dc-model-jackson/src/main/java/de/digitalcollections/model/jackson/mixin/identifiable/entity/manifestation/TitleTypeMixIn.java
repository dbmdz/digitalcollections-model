package de.digitalcollections.model.jackson.mixin.identifiable.entity.manifestation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.manifestation.TitleType;
import de.digitalcollections.model.jackson.mixin.MainSubTypeMixIn;

@JsonDeserialize(as = TitleType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("TITLE_TYPE")
public interface TitleTypeMixIn extends MainSubTypeMixIn {}
