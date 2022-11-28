package de.digitalcollections.model.identifiable.entity.manifestation;

import de.digitalcollections.model.identifiable.entity.work.Work;
import de.digitalcollections.model.identifiable.entity.work.WorkType;
import java.util.LinkedHashMap;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class Series extends Work {

  private LinkedHashMap<String, Manifestation> sortedManifestations;

  public Series() {
    super();
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

  public abstract static class SeriesBuilder<C extends Series, B extends SeriesBuilder<C, B>>
      extends WorkBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }
  }
}
