package de.digitalcollections.model.api.identifiable;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.resource.IiifImage;
import java.time.LocalDateTime;
import java.util.UUID;

public interface Identifiable {

  LocalDateTime getCreated();

  LocalizedStructuredContent getDescription();

  LocalizedText getLabel();

  LocalDateTime getLastModified();

  IiifImage getIiifImage();

  IdentifiableType getType();

  UUID getUuid();

  void setCreated(LocalDateTime created);

  void setDescription(LocalizedStructuredContent description);

  void setLabel(LocalizedText label);

  void setLastModified(LocalDateTime lastModified);

  void setIiifImage(IiifImage thumbnail);

  void setType(IdentifiableType identifiableType);

  void setUuid(UUID uuid);
}
