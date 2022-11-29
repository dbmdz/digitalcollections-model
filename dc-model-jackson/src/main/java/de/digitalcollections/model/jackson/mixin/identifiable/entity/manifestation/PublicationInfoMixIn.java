package de.digitalcollections.model.jackson.mixin.identifiable.entity.manifestation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.manifestation.PublicationInfo;

@JsonDeserialize(as = PublicationInfo.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("PUBLICATION_INFO")
public interface PublicationInfoMixIn {}