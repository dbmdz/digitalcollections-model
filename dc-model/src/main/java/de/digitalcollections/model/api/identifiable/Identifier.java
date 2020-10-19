package de.digitalcollections.model.api.identifiable;

import java.util.UUID;

/**
 * An Identifier identifies an object uniquely in an external system that created the id. Each
 * system is identified by a namespace.
 *
 * <p>Examples: GND-ID ("gnd:104330171") or VIAF-ID ("viaf:96994450")
 */
public interface Identifier {

  UUID getUuid();

  void setUuid(UUID uuid);

  String getId();

  UUID getIdentifiable();

  String getNamespace();

  void setId(String id);

  void setIdentifiable(UUID identifiable);

  void setNamespace(String namespace);
}
