package de.digitalcollections.model.api.identifiable.agent;

import de.digitalcollections.model.api.identifiable.Identifiable;

/**
 * see WikiData https://www.wikidata.org/wiki/Q202444: "Name typically used to differentiate people
 * from the same family, clan, or other social group who have a common last name."
 */
public interface GivenName extends Identifiable {
  public static enum Gender {
    MALE, // see https://www.wikidata.org/wiki/Q12308941
    FEMALE, // see https://www.wikidata.org/wiki/Q11879590
    UNISEX; // see https://www.wikidata.org/wiki/Q3409032
  }

  Gender getGender();

  void setGender(Gender gender);
}
