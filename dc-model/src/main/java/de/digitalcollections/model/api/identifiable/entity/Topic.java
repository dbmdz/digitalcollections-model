package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.parts.Subtopic;
import java.util.List;

/**
 * https://www.merriam-webster.com/dictionary/topic: "the subject of something that is being
 * discussed or has been written or thought about"
 * https://www.linguee.com/english-german/translation/topic.html german: "Thema, Inhalt, Gegenstand,
 * Gesprächsthema" or "Thematik, Themengebiet, Themenbereich"
 */
public interface Topic extends Entity {

  void addSubtopic(Subtopic subtopic);

  List<Subtopic> getSubtopics();

  void setSubtopics(List<Subtopic> subTopics);
}
