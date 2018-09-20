package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiablesContainer;
import java.util.List;

public class IdentifiablesContainerImpl implements IdentifiablesContainer {

  private List<Identifiable> identifiables;

  @Override
  public List<Identifiable> getIdentifiables() {
    return identifiables;
  }

  @Override
  public void setIdentifiables(List<Identifiable> identifiables) {
    this.identifiables = identifiables;
  }

}
