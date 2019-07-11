package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Version;
import java.util.Date;
import java.util.UUID;

public class VersionImpl implements Version {

  UUID uuid;
  int versionValue;
  Date created;
  String description;
  Status status = Status.INITIAL;
  TypeKey typeKey = TypeKey.DIGITALOBJECT;
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
  public int getVersionValue() {
    return versionValue;
  }

  @Override
  public void setVersionValue(int versionValue) {
    this.versionValue = versionValue;
  }

  @Override
  public Date getCreated() {
    return created;
  }

  @Override
  public void setCreated(Date created) {
    this.created = created;
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
  public Status getStatus() {
    return status;
  }

  @Override
  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public TypeKey getTypeKey() {
    return typeKey;
  }

  @Override
  public void setTypeKey(TypeKey typeKey) {
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
           + ", value=" + versionValue
           + ", status='" + status + '\''
           + ", typeKey='" + typeKey + '\''
           + ", instanceKey='" + instanceKey + '\''
           + ", instanceVersionKey='" + instanceVersionKey + '\''
           + '}';
  }
}
