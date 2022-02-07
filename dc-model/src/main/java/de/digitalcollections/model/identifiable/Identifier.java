package de.digitalcollections.model.identifiable;

import de.digitalcollections.model.UniqueObject;
import java.util.Objects;
import java.util.UUID;

/**
 * An Identifier identifies an object uniquely in an external system that created the id. Each
 * system is identified by a namespace.
 *
 * <p>Examples: GND-ID ("gnd:104330171") or VIAF-ID ("viaf:96994450")
 */
public class Identifier extends UniqueObject {

  private static final long serialVersionUID = 1L;

  private String id;
  private UUID identifiable;
  private String namespace;

  public Identifier() {}

  public Identifier(UUID identifiable, String namespace, String id) {
    this.id = id;
    this.identifiable = identifiable;
    this.namespace = namespace;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Identifier) {
      final Identifier other = (Identifier) obj;
      return Objects.equals(this.id, other.getId())
          && Objects.equals(this.namespace, other.getNamespace());
    }
    return false;
  }

  public String getId() {
    return id;
  }

  public UUID getIdentifiable() {
    return this.identifiable;
  }

  public String getNamespace() {
    return namespace;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, namespace);
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setIdentifiable(UUID identifiable) {
    this.identifiable = identifiable;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  @Override
  public String toString() {
    return namespace + ":" + id + ":" + identifiable;
  }
}
