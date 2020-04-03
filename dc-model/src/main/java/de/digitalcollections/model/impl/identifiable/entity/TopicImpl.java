package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Topic;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.parts.Subtopic;
import java.util.ArrayList;
import java.util.List;

/** see {@link Topic} */
public class TopicImpl extends EntityImpl implements Topic {

  private List<Subtopic> subtopics = new ArrayList<>();

  public TopicImpl() {
    super();
    this.entityType = EntityType.TOPIC;
  }

  public TopicImpl(List<Subtopic> rootNodes) {
    this();
    this.subtopics = rootNodes;
  }

  @Override
  public List<Subtopic> getSubtopics() {
    return subtopics;
  }

  @Override
  public void setSubtopics(List<Subtopic> rootNodes) {
    this.subtopics = rootNodes;
  }

  @Override
  public void addSubtopic(Subtopic subtopic) {
    this.subtopics.add(subtopic);
  }
}
