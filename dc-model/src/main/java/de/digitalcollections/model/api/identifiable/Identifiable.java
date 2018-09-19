package de.digitalcollections.model.api.identifiable;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDateTime;
import java.util.UUID;

public interface Identifiable {

  LocalDateTime getCreated();

  LocalizedStructuredContent getDescription();

  LocalizedText getLabel();

  LocalDateTime getLastModified();

  IdentifiableType getType();

  UUID getUuid();

  void setCreated(LocalDateTime created);

  void setDescription(LocalizedStructuredContent description);

  void setLabel(LocalizedText label);

  void setLastModified(LocalDateTime lastModified);

  void setType(IdentifiableType identifiableType);

  void setUuid(UUID uuid);
}
