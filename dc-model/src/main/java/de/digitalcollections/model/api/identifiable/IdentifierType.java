package de.digitalcollections.model.api.identifiable;

import java.util.UUID;

public interface IdentifierType {

  String getLabel();

  void setLabel(String label);

  String getNamespace();

  void setNamespace(String namespace);

  String getPattern();

  void setPattern(String pattern);

  UUID getUuid();

  void setUuid(UUID uuid);
}
