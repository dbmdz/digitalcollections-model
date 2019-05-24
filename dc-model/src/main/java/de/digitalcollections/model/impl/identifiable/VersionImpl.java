package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Version;
import java.util.Date;
import java.util.UUID;

public class VersionImpl implements Version {

  UUID uuid;
  String externalKey;
  int value;
  Date creationDate;
  String description;
  String status;

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
  public String getExternalKey() {
    return externalKey;
  }

  @Override
  public void setExternalKey(String externalKey) {
    this.externalKey = externalKey;
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
  public String getStatus(String status) {
    return status;
  }

  @Override
  public void setStatus(String status) {
    this.status = status;
  }
}
