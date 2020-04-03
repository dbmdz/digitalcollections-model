package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.TopicImpl;

@JsonDeserialize(as = TopicImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("TOPIC")
public interface TopicMixIn {}
