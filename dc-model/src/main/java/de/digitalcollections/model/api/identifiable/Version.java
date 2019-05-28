package de.digitalcollections.model.api.identifiable;

import java.util.Date;
import java.util.UUID;

public interface Version {

  UUID getUuid();

  void setUuid(UUID uuid);

  int getVersionValue();

  void setVersionValue(int value);

  Date getCreated();

  void setCreated(Date date);

  String getDescription();

  void setDescription(String description);

  String getStatus();

  void setStatus(String status);

  String getTypeKey();

  void setTypeKey(String typeKey);

  String getInstanceKey();

  void setInstanceKey(String instanceKey);

  String getInstanceVersionKey();

  void setInstanceVersionKey(String instanceVersionKey);
}
