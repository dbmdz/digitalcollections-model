package de.digitalcollections.model.api.identifiable;

import java.util.UUID;

/**
 * Defines an identifier type to be used in the system implementing this library. It is up to the
 * implementor to add all relevant identifier types to his system. Each IdentifierType can be
 * described by a label, a namespace (describing the system) and a regex pattern for validating
 * identifiers.
 */
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
