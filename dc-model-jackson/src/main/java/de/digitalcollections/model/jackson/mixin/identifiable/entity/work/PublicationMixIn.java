package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.work.Publication;

@JsonDeserialize(as = Publication.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface PublicationMixIn {}
