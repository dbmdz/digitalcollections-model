package de.digitalcollections.model.api.identifiable.entity.agent;

import de.digitalcollections.model.api.identifiable.agent.FamilyName;
import de.digitalcollections.model.api.identifiable.agent.GivenName;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.agent.enums.Gender;
import de.digitalcollections.model.api.identifiable.entity.geo.GeoLocation;
import java.time.LocalDate;
import java.util.List;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

/** Human being that has certain capacities or attributes constituting personhood. */
public interface Person extends Entity, Agent {

  LocalDate getDateOfBirth();

  void setDateOfBirth(LocalDate dateOfBirth);

  GeoLocation getPlaceOfBirth();

  void setPlaceOfBirth(GeoLocation placeOfBirth);

  LocalDate getDateOfDeath();

  void setDateOfDeath(LocalDate dateOfDeath);

  GeoLocation getPlaceOfDeath();

  void setPlaceOfDeath(GeoLocation placeOfDeath);

  // family names (more than one when change during life, e.g. at marriage;
  // first one is name at birth)
  List<FamilyName> getFamilyNames();

  void setFamilyNames(List<FamilyName> familyNames);

  List<GivenName> getGivenNames();

  void setGivenNames(List<GivenName> givenNames);

  TimeValue getTimeValueOfBirth();

  void setTimeValueOfBirth(TimeValue timeValueOfBirth);

  TimeValue getTimeValueOfDeath();

  void setTimeValueOfDeath(TimeValue timeValueOfDeath);

  Gender getGender();

  void setGender(Gender gender);
}
