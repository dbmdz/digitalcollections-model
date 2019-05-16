package de.digitalcollections.model.api.identifiable;

public interface IdentifierType {

  String getIdPattern();

  String getLabel();

  String getNamespace();

  void setIdPattern(String idPattern);

  void setLabel(String label);

  void setNamespace(String namespace);
}
