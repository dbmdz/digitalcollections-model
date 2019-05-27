package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Version;
import java.util.Date;
import java.util.UUID;

public class VersionImpl implements Version {

  UUID uuid;
  int value;
  Date creationDate;
  String description;
  String status;
  String typeKey;
  String instanceKey;
  String instanceVersionKey;

  public VersionImpl() {
  }

  @Override
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  @Override
  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  @Override
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String getStatus() {
    return status;
  }

  @Override
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String getTypeKey() {
    return typeKey;
  }

  @Override
  public void setTypeKey(String typeKey) {
    this.typeKey = typeKey;
  }

  @Override
  public String getInstanceKey() {
    return instanceKey;
  }

  @Override
  public void setInstanceKey(String instanceKey) {
    this.instanceKey = instanceKey;
  }

  @Override
  public String getInstanceVersionKey() {
    return instanceVersionKey;
  }

  @Override
  public void setInstanceVersionKey(String instanceVersionKey) {
    this.instanceVersionKey = instanceVersionKey;
  }

  @Override
  public String toString() {
    return "VersionImpl{"
           + "uuid=" + uuid
           + ", value=" + value
           + ", status='" + status + '\''
           + ", typeKey='" + typeKey + '\''
           + ", instanceKey='" + instanceKey + '\''
           + ", instanceVersionKey='" + instanceVersionKey + '\''
           + '}';
  }
}
