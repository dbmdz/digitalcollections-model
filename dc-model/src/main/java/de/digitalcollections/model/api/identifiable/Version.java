package de.digitalcollections.model.api.identifiable;

import java.util.Date;
import java.util.UUID;

/** Version of a {@link de.digitalcollections.model.api.identifiable.entity.DigitalObject} */
public interface Version {

  enum Status {
    INITIAL,
    ACTIVE,
    INACTIVE,
    DELETED
  }

  enum TypeKey {
    DIGITALOBJECT
  }

  /** @return id of the version */
  UUID getUuid();

  void setUuid(UUID uuid);

  /** @return numeric value of the version, incremented with every new version instance */
  int getVersionValue();

  void setVersionValue(int value);

  /** @return date when this version instance was created */
  Date getCreated();

  void setCreated(Date date);

  /** @return description of the version, intended for manually created versions */
  String getDescription();

  void setDescription(String description);

  /** @return status of the version, one of 'INITIAL', 'ACTIVIE', 'INACTIVE', 'DELETED' */
  Status getStatus();

  void setStatus(Status status);

  /** @return type of the versioned object, e.g. 'DigitalObject' */
  TypeKey getTypeKey();

  void setTypeKey(TypeKey typeKey);

  /** @return version independent identifier of the versioned object, e.g. Zend id */
  String getInstanceKey();

  void setInstanceKey(String instanceKey);

  /**
   * @return unique identifier of the version, typically a combination of the instance key and an
   *     external property such as a creation date.
   */
  String getInstanceVersionKey();

  void setInstanceVersionKey(String instanceVersionKey);
}
