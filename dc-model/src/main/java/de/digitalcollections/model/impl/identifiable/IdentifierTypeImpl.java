package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.IdentifierType;

public class IdentifierTypeImpl implements IdentifierType {

  private long id;
  private String label;
  private String namespace;
  private String pattern;

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

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
}
