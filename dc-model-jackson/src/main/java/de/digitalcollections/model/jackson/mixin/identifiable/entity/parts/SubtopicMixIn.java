package de.digitalcollections.model.jackson.mixin.identifiable.entity.parts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.parts.SubtopicImpl;

@JsonDeserialize(as = SubtopicImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("subtopic")
public interface SubtopicMixIn {}
