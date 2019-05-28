package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.IdentifierType;
import java.util.UUID;

public class IdentifierTypeImpl implements IdentifierType {

  private String label;
  private String namespace;
  private String pattern;
  private UUID uuid;

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public void setLabel(String label) {
    this.label = label;
  }

  @Override
  public String getNamespace() {
    return namespace;
  }

  @Override
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  @Override
  public String getPattern() {
    return pattern;
  }

  @Override
  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  @Override
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
