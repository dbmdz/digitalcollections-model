package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.util.ArrayList;
import java.util.List;

/** A collection of {@link Entity}s. */
public interface Collection extends Entity, Node<Collection> {

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);

  List<Entity> getEntities();

  void setEntities(List<Entity> entities);

  default void addEntity(Entity entity) {
    if (getEntities() == null) {
      setEntities(new ArrayList<>());
    }
    getEntities().add(entity);
  }
}
