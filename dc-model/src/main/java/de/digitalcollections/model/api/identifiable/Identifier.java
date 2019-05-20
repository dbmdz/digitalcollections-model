package de.digitalcollections.model.api.identifiable;

import java.util.UUID;

public interface Identifier {

  String getId();

  UUID getIdentifiableUuid();

  String getNamespace();

  void setId(String id);

  void setIdentifiableUuid(UUID identifiableUuid);

  void setNamespace(String namespace);
}
