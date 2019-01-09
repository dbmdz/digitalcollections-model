package de.digitalcollections.model.api.identifiable;

import java.util.ArrayList;
import java.util.List;

public interface IdentifiablesContainer {

  List<Identifiable> getIdentifiables();

  void setIdentifiables(List<Identifiable> identifiable);

  default void addIdentifiable(Identifiable identifiable) {
    if (getIdentifiables() == null) {
      setIdentifiables(new ArrayList<>());
    }
    getIdentifiables().add(identifiable);
  }
}
