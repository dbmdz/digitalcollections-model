package de.digitalcollections.model.identifiable;

import de.digitalcollections.model.UniqueObject;
import java.util.UUID;

/**
 * Defines an identifier type to be used in the system implementing this library. It is up to the
 * implementor to add all relevant identifier types to his system. Each IdentifierType can be
 * described by a label, a namespace (describing the system) and a regex pattern for validating
 * identifiers.
 */
public class IdentifierType extends UniqueObject {

  private String label;
  private String namespace;
  private String pattern;

  public String getLabel() {
    return label;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getPattern() {
    return pattern;
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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    public IdentifierType identifierType = new IdentifierType();

    public IdentifierType build() {
      return identifierType;
    }

    public Builder withLabel(String label) {
      identifierType.setLabel(label);
      return this;
    }

    public Builder withNamespace(String namespace) {
      identifierType.setNamespace(namespace);
      return this;
    }

    public Builder withPattern(String pattern) {
      identifierType.setPattern(pattern);
      return this;
    }

    public Builder withUuid(String uuid) {
      identifierType.setUuid(UUID.fromString(uuid));
      return this;
    }
  }
}
