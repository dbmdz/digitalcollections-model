package de.digitalcollections.model.production;

import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import java.time.LocalDate;

public class CreationInfoBuilder {
  CreationInfo creationInfo = new CreationInfo();

  public CreationInfoBuilder withGeoLocation(GeoLocation geoLocation) {
    creationInfo.setGeoLocation(geoLocation);
    return this;
  }

  public CreationInfoBuilder withCreator(Agent creator) {
    creationInfo.setCreator(creator);
    return this;
  }

  public CreationInfoBuilder withDate(String date) {
    creationInfo.setDate(LocalDate.parse(date));
    return this;
  }

  public CreationInfo build() {
    return creationInfo;
  }
}
