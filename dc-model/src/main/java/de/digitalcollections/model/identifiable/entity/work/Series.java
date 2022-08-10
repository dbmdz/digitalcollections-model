package de.digitalcollections.model.identifiable.entity.work;

import java.util.LinkedHashMap;

public class Series extends Work {

  private LinkedHashMap<String, Manifestation> sortedManifestations;

  public Series() {
    super();
    init();
  }

  public LinkedHashMap<String, Manifestation> getSortedManifestations() {
    return sortedManifestations;
  }

  @Override
  protected void init() {
    super.init();
    workType = WorkType.SERIES;
  }

  public void setSortedManifestations(LinkedHashMap<String, Manifestation> sortedManifestations) {
    this.sortedManifestations = sortedManifestations;
  }
}
