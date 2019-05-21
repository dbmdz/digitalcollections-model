package de.digitalcollections.model.api.identifiable;

import java.util.UUID;

public interface Identifier {

  UUID getUuid();

  void setUuid(UUID uuid);

  String getId();

  UUID getIdentifiable();

  String getNamespace();

  void setId(String id);

  void setIdentifiable(UUID identifiable);

  void setNamespace(String namespace);
}
