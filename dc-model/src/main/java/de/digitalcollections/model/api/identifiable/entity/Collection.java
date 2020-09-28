package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** A collection of {@link Entity}s. */
public interface Collection extends Entity, Node<Collection> {

  default void addEntity(Entity entity) {
    if (getEntities() == null) {
      setEntities(new ArrayList<>());
    }
    getEntities().add(entity);
  }

  List<Entity> getEntities();

  void setEntities(List<Entity> entities);

  LocalDate getPublicationEnd();

  void setPublicationEnd(LocalDate publicationEnd);

  LocalDate getPublicationStart();

  void setPublicationStart(LocalDate publicationStart);

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);
}
