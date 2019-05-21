package de.digitalcollections.model.api.identifiable;

public interface IdentifierType {

  long getId();

  void setId(long id);

  String getLabel();

  void setLabel(String label);

  String getNamespace();

  void setNamespace(String namespace);

  String getPattern();

  void setPattern(String pattern);
}
