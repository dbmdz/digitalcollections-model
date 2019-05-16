package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Identifier;
import java.io.Serializable;

public class IdentifierImpl implements Identifier, Serializable {

  private String id;

  private String namespace;

  public IdentifierImpl() {
  }

  public IdentifierImpl(String namespace, String id) {
    this.id = id;
    this.namespace = namespace;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
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
  public String toString() {
    return namespace + ":" + id;
  }
}
