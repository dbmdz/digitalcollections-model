package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.merriam-webster.com/dictionary/subtopic: "a (subtopic is a) topic that is part of a
 * broader or more general topic ..." "a (subtopic is a) topic that is one of the parts or divisions
 * of the main topic ..." "a (subtopic is a) topic (as in a composition) that is a division of a
 * main topic" https://www.linguee.com/english-german/translation/subtopic.html german: "Unterthema"
 */
public interface Subtopic extends Node<Subtopic>, EntityPart {

  List<Entity> getEntities();

  void setEntities(List<Entity> entities);

  default List<Entity> addEntity(Entity entity) {
    if (getEntities() == null) {
      setEntities(new ArrayList<>());
    }
    getEntities().add(entity);
    return getEntities();
  }

  List<FileResource> getFileResources();

  void setFileResources(List<FileResource> fileResources);

  default List<FileResource> addFileResource(FileResource fileResource) {
    if (getFileResources() == null) {
      setFileResources(new ArrayList<>());
    }
    getFileResources().add(fileResource);
    return getFileResources();
  }
}
