package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import java.util.ArrayList;
import java.util.List;

public interface ContentNode<N extends Node> extends Node<N>, EntityPart {

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
