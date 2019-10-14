package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Identifier;
import java.io.Serializable;
import java.util.UUID;

public class IdentifierImpl implements Identifier, Serializable {

  private String id;
  private UUID identifiable;
  private String namespace;
  private UUID uuid;

  public IdentifierImpl() {}

  public IdentifierImpl(UUID identifiable, String namespace, String id) {
    this.id = id;
    this.identifiable = identifiable;
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
  public UUID getIdentifiable() {
    return this.identifiable;
  }

  @Override
  public void setIdentifiable(UUID identifiable) {
    this.identifiable = identifiable;
  }

  @Override
  public String getNamespace() {
    return namespace;
  }

  @Override
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  @Override
  public String toString() {
    return namespace + ":" + id + ":" + identifiable;
  }
}
