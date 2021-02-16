package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.Topic;

@JsonDeserialize(as = Topic.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("TOPIC")
public interface TopicMixIn {}
