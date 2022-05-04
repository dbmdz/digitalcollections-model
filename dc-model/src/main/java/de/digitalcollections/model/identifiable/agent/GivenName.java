package de.digitalcollections.model.identifiable.agent;

import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Set;

/**
 * see WikiData https://www.wikidata.org/wiki/Q202444: "Name typically used to differentiate people
 * from the same family, clan, or other social group who have a common last name."
 */
public class GivenName extends Identifiable {

  private Gender gender;

  public GivenName() {
    super();
    init();
  }

  @Override
  protected void init() {
    super.init();
    this.type = IdentifiableType.RESOURCE;
  }

  public GivenName(Gender gender, LocalizedText label, Set<Identifier> identifiers) {
    this();
    this.gender = gender;
    this.label = label;
    getIdentifiers().addAll(identifiers);
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public static enum Gender {
    MALE, // see https://www.wikidata.org/wiki/Q12308941
    FEMALE, // see https://www.wikidata.org/wiki/Q11879590
    UNISEX; // see https://www.wikidata.org/wiki/Q3409032
  }
}
