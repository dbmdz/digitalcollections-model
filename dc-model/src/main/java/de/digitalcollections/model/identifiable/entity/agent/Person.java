package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.agent.FamilyName;
import de.digitalcollections.model.identifiable.agent.GivenName;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import de.digitalcollections.model.text.LocalizedText;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.experimental.SuperBuilder;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

/** Human being that has certain capacities or attributes constituting personhood. */
@SuperBuilder
public class Person extends Agent {

  private LocalDate dateOfBirth;
  private LocalDate dateOfDeath;
  private List<FamilyName> familyNames = new ArrayList<>();
  private Gender gender;
  private List<GivenName> givenNames = new ArrayList<>();
  private GeoLocation placeOfBirth;
  private GeoLocation placeOfDeath;
  private TimeValue timeValueOfBirth;
  private TimeValue timeValueOfDeath;

  public Person() {
    super();
    this.entityType = EntityType.PERSON;
  }

  public Person(LocalizedText label, Set<Identifier> identifiers) {
    this();
    this.label = label;
    this.identifiers.addAll(identifiers);
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public LocalDate getDateOfDeath() {
    return dateOfDeath;
  }

  /**
   * @return family names (more than one when change during life, e.g. at marriage; first one is
   *     name at birth)
   */
  public List<FamilyName> getFamilyNames() {
    return familyNames;
  }

  public Gender getGender() {
    return gender;
  }

  public List<GivenName> getGivenNames() {
    return givenNames;
  }

  public GeoLocation getPlaceOfBirth() {
    return placeOfBirth;
  }

  public GeoLocation getPlaceOfDeath() {
    return placeOfDeath;
  }

  public TimeValue getTimeValueOfBirth() {
    return timeValueOfBirth;
  }

  public TimeValue getTimeValueOfDeath() {
    return timeValueOfDeath;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setDateOfDeath(LocalDate dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }

  public void setFamilyNames(List<FamilyName> familyNames) {
    this.familyNames = familyNames;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setGivenNames(List<GivenName> givenNames) {
    this.givenNames = givenNames;
  }

  public void setPlaceOfBirth(GeoLocation placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public void setPlaceOfDeath(GeoLocation placeOfDeath) {
    this.placeOfDeath = placeOfDeath;
  }

  public void setTimeValueOfBirth(TimeValue timeValueOfBirth) {
    this.timeValueOfBirth = timeValueOfBirth;
  }

  public void setTimeValueOfDeath(TimeValue timeValueOfDeath) {
    this.timeValueOfDeath = timeValueOfDeath;
  }
}
