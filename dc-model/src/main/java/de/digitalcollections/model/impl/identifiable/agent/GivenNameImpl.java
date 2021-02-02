package de.digitalcollections.model.impl.identifiable.agent;

import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.Identifier;
import de.digitalcollections.model.api.identifiable.agent.GivenName;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.impl.identifiable.IdentifiableImpl;
import java.util.Set;

public class GivenNameImpl extends IdentifiableImpl implements GivenName {

  private Gender gender;

  public GivenNameImpl() {
    super();
    this.type = IdentifiableType.RESOURCE;
  }

  public GivenNameImpl(Gender gender, LocalizedText label, Set<Identifier> identifiers) {
    this();
    this.gender = gender;
    this.label = label;
    getIdentifiers().addAll(identifiers);
  }

  @Override
  public Gender getGender() {
    return gender;
  }

  @Override
  public void setGender(Gender gender) {
    this.gender = gender;
  }
}
