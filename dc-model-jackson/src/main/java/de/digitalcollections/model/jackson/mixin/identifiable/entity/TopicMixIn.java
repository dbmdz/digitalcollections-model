package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.Node;
import de.digitalcollections.model.identifiable.entity.Topic;

@JsonDeserialize(as = Topic.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("topic")
public interface TopicMixIn extends EntityMixIn {

  @JsonIgnore
  Node<Topic> getNode();
}
