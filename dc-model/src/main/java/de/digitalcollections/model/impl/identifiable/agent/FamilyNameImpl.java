package de.digitalcollections.model.impl.identifiable.agent;

import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.Identifier;
import de.digitalcollections.model.api.identifiable.agent.FamilyName;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;
import java.util.Set;

public class FamilyNameImpl extends IdentifiableImpl implements FamilyName {

  public FamilyNameImpl() {
    super();
    this.type = IdentifiableType.RESOURCE;
  }

  public FamilyNameImpl(LocalizedText label, Set<Identifier> identifiers) {
    this();
    this.label = label;
    getIdentifiers().addAll(identifiers);
  }
}
