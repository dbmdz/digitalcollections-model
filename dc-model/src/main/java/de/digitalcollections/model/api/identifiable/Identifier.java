package de.digitalcollections.model.api.identifiable;

public interface Identifier {

  String getId();

  String getNamespace();

  void setId(String id);

  void setNamespace(String namespace);
}
