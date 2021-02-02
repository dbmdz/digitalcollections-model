package de.digitalcollections.model.impl.identifiable.entity.agent;

import de.digitalcollections.model.api.identifiable.Identifier;
import de.digitalcollections.model.api.identifiable.agent.FamilyName;
import de.digitalcollections.model.api.identifiable.agent.GivenName;
import de.digitalcollections.model.api.identifiable.entity.agent.Person;
import de.digitalcollections.model.api.identifiable.entity.agent.enums.Gender;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.geo.GeoLocation;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

public class PersonImpl extends AgentImpl implements Person {

  private LocalDate dateOfBirth;
  private LocalDate dateOfDeath;
  private List<FamilyName> familyNames = new ArrayList<>(1);
  private Gender gender;
  private List<GivenName> givenNames = new ArrayList<>(1);
  private GeoLocation placeOfBirth;
  private GeoLocation placeOfDeath;
  private TimeValue timeValueOfBirth;
  private TimeValue timeValueOfDeath;

  public PersonImpl() {
    super();
    this.entityType = EntityType.PERSON;
  }

  public PersonImpl(LocalizedText label, Set<Identifier> identifiers) {
    this();
    this.label = label;
    this.identifiers.addAll(identifiers);
  }

  @Override
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  @Override
  public LocalDate getDateOfDeath() {
    return dateOfDeath;
  }

  @Override
  public List<FamilyName> getFamilyNames() {
    return familyNames;
  }

  @Override
  public Gender getGender() {
    return gender;
  }

  @Override
  public List<GivenName> getGivenNames() {
    return givenNames;
  }

  @Override
  public GeoLocation getPlaceOfBirth() {
    return placeOfBirth;
  }

  @Override
  public GeoLocation getPlaceOfDeath() {
    return placeOfDeath;
  }

  @Override
  public TimeValue getTimeValueOfBirth() {
    return timeValueOfBirth;
  }

  @Override
  public TimeValue getTimeValueOfDeath() {
    return timeValueOfDeath;
  }

  @Override
  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public void setDateOfDeath(LocalDate dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }

  @Override
  public void setFamilyNames(List<FamilyName> familyNames) {
    this.familyNames = familyNames;
  }

  @Override
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public void setGivenNames(List<GivenName> givenNames) {
    this.givenNames = givenNames;
  }

  @Override
  public void setPlaceOfBirth(GeoLocation placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  @Override
  public void setPlaceOfDeath(GeoLocation placeOfDeath) {
    this.placeOfDeath = placeOfDeath;
  }

  @Override
  public void setTimeValueOfBirth(TimeValue timeValueOfBirth) {
    this.timeValueOfBirth = timeValueOfBirth;
  }

  @Override
  public void setTimeValueOfDeath(TimeValue timeValueOfDeath) {
    this.timeValueOfDeath = timeValueOfDeath;
  }
}
