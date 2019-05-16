package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.IdentifierType;

public class IdentifierTypeImpl implements IdentifierType {

  private String idPattern;

  private String label;

  private String namespace;

  @Override
  public String getIdPattern() {
    return idPattern;
  }

  @Override
  public void setIdPattern(String idPattern) {
    this.idPattern = idPattern;
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
}
