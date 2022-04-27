package de.digitalcollections.model.identifiable.versioning;

import java.util.Date;
import java.util.UUID;

/** Version of a {@link de.digitalcollections.model.identifiable.entity.DigitalObject} */
public class Version {

  private Date created;
  private String description;
  private String instanceKey;
  private String instanceVersionKey;
  private Status status = Status.INITIAL;
  private TypeKey typeKey = TypeKey.DIGITALOBJECT;
  private UUID uuid;
  private int versionValue;

  public Version() {}

  /** @return date when this version instance was created */
  public Date getCreated() {
    return created;
  }

  /** @return description of the version, intended for manually created versions */
  public String getDescription() {
    return description;
  }

  /** @return version independent identifier of the versioned object, e.g. Zend id */
  public String getInstanceKey() {
    return instanceKey;
  }

  /**
   * @return unique identifier of the version, typically a combination of the instance key and an
   *     external property such as a creation date.
   */
  public String getInstanceVersionKey() {
    return instanceVersionKey;
  }

  /** @return status of the version, one of 'INITIAL', 'ACTIVIE', 'INACTIVE', 'DELETED' */
  public Status getStatus() {
    return status;
  }

  /** @return type of the versioned object, e.g. 'DigitalObject' */
  public TypeKey getTypeKey() {
    return typeKey;
  }

  /** @return id of the version */
  public UUID getUuid() {
    return uuid;
  }

  /** @return numeric value of the version, incremented with every new version instance */
  public int getVersionValue() {
    return versionValue;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setInstanceKey(String instanceKey) {
    this.instanceKey = instanceKey;
  }

  public void setInstanceVersionKey(String instanceVersionKey) {
    this.instanceVersionKey = instanceVersionKey;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setTypeKey(TypeKey typeKey) {
    this.typeKey = typeKey;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public void setVersionValue(int versionValue) {
    this.versionValue = versionValue;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
        + "{uuid="
        + uuid
        + ", value="
        + versionValue
        + ", status='"
        + status
        + "', typeKey='"
        + typeKey
        + "', instanceKey='"
        + instanceKey
        + "', instanceVersionKey='"
        + instanceVersionKey
        + "'}";
  }

  public static class Builder {

    public Version version = new Version();

    public Version build() {
      return version;
    }

    public Builder withUuid(UUID uuid) {
      version.setUuid(uuid);
      return this;
    }

    public Builder withValue(int value) {
      version.setVersionValue(value);
      return this;
    }
  }
}
