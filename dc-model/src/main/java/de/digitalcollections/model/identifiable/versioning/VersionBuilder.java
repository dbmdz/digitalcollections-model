package de.digitalcollections.model.identifiable.versioning;

import java.util.UUID;

public class VersionBuilder {

  public Version version = new Version();

  public Version build() {
    return version;
  }

  public VersionBuilder withUuid(UUID uuid) {
    version.setUuid(uuid);
    return this;
  }

  public VersionBuilder withValue(int value) {
    version.setVersionValue(value);
    return this;
  }
}
