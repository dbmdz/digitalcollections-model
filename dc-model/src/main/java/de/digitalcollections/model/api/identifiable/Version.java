package de.digitalcollections.model.api.identifiable;

import java.util.Date;
import java.util.UUID;

public interface Version {

  UUID getUuid();

  void setUuid(UUID uuid);

  String getExternalKey();

  void setExternalKey(String externalKey);

  int getValue();

  void setValue(int value);

  Date getCreationDate();

  void setCreationDate(Date date);

  String getDescription();

  void setDescription(String description);

  String getStatus(String status);

  void setStatus(String status);
}
