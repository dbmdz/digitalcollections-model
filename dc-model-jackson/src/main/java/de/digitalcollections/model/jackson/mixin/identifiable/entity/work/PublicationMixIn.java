package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.work.Publication;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;

@JsonDeserialize(as = Publication.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("PUBLICATION")
public interface PublicationMixIn extends UniqueObjectMixIn {}
