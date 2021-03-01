package de.digitalcollections.model.identifiable;

import java.util.UUID;

/**
 * Defines an identifier type to be used in the system implementing this library. It is up to the
 * implementor to add all relevant identifier types to his system. Each IdentifierType can be
 * described by a label, a namespace (describing the system) and a regex pattern for validating
 * identifiers.
 */
public class IdentifierType {

  private String label;
  private String namespace;
  private String pattern;
  private UUID uuid;

  public String getLabel() {
    return label;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getPattern() {
    return pattern;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
