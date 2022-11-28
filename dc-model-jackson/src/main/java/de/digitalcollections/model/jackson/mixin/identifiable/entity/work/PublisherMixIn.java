package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.manifestation.Publisher;

@JsonDeserialize(as = Publisher.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("PUBLISHER")
public interface PublisherMixIn {}
