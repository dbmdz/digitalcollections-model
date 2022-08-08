package de.digitalcollections.model.identifiable.entity.work;

import java.util.LinkedHashMap;

public class Series extends Work {

  private LinkedHashMap<String, Manifestation> sortedManifestations;

  public LinkedHashMap<String, Manifestation> getSortedManifestations() {
    return sortedManifestations;
  }

  public void setSortedManifestations(LinkedHashMap<String, Manifestation> sortedManifestations) {
    this.sortedManifestations = sortedManifestations;
  }
}
