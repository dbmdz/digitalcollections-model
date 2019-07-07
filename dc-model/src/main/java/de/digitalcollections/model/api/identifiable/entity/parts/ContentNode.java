package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import java.util.LinkedHashSet;

public interface ContentNode<N extends Node> extends Node<N>, EntityPart {

  LinkedHashSet<Entity> getEntities();

  void setEntities(LinkedHashSet<Entity> entities);

  default LinkedHashSet<Entity> addEntity(Entity entity) {
    if (getEntities() == null) {
      setEntities(new LinkedHashSet<>());
    }
    getEntities().add(entity);
    return getEntities();
  }

  LinkedHashSet<FileResource> getFileResources();

  void setFileResources(LinkedHashSet<FileResource> fileResources);

  default LinkedHashSet<FileResource> addFileResource(FileResource fileResource) {
    if (getFileResources() == null) {
      setFileResources(new LinkedHashSet<>());
    }
    getFileResources().add(fileResource);
    return getFileResources();
  }
}
