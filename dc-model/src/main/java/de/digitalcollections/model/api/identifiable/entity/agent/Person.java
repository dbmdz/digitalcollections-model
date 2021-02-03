package de.digitalcollections.model.api.identifiable.entity.agent;

import de.digitalcollections.model.api.identifiable.agent.FamilyName;
import de.digitalcollections.model.api.identifiable.agent.GivenName;
import de.digitalcollections.model.api.identifiable.entity.agent.enums.Gender;
import de.digitalcollections.model.api.identifiable.entity.geo.GeoLocation;
import java.time.LocalDate;
import java.util.List;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

/** Human being that has certain capacities or attributes constituting personhood. */
public interface Person extends Agent {

  LocalDate getDateOfBirth();

  LocalDate getDateOfDeath();

  // family names (more than one when change during life, e.g. at marriage;
  // first one is name at birth)
  List<FamilyName> getFamilyNames();

  Gender getGender();

  List<GivenName> getGivenNames();

  GeoLocation getPlaceOfBirth();

  GeoLocation getPlaceOfDeath();

  TimeValue getTimeValueOfBirth();

  TimeValue getTimeValueOfDeath();

  void setDateOfBirth(LocalDate dateOfBirth);

  void setDateOfDeath(LocalDate dateOfDeath);

  void setFamilyNames(List<FamilyName> familyNames);

  void setGender(Gender gender);

  void setGivenNames(List<GivenName> givenNames);

  void setPlaceOfBirth(GeoLocation placeOfBirth);

  void setPlaceOfDeath(GeoLocation placeOfDeath);

  void setTimeValueOfBirth(TimeValue timeValueOfBirth);

  void setTimeValueOfDeath(TimeValue timeValueOfDeath);
}
