package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Identifier;
import java.io.Serializable;
import java.util.UUID;

public class IdentifierImpl implements Identifier, Serializable {

  private String id;

  private UUID identifiableUuid;

  private String namespace;

  public IdentifierImpl() {
  }

  public IdentifierImpl(UUID identifiableUuid, String namespace, String id) {
    this.id = id;
    this.identifiableUuid = identifiableUuid;
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
  public UUID getIdentifiableUuid() {
    return this.identifiableUuid;
  }

  @Override
  public void setIdentifiableUuid(UUID identifiableUuid) {
    this.identifiableUuid = identifiableUuid;
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
    return namespace + ":" + id + ":" + identifiableUuid;
  }
}
