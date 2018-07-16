package de.digitalcollections.model.api.identifiable;

import de.digitalcollections.model.api.identifiable.parts.Text;
import de.digitalcollections.model.api.identifiable.resource.IiifImage;
import java.time.LocalDateTime;
import java.util.UUID;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;

public interface Identifiable {

  LocalDateTime getCreated();

  LocalizedStructuredContent getDescription();

  Text getLabel();

  LocalDateTime getLastModified();

  IiifImage getIiifImage();

  IdentifiableType getType();

  UUID getUuid();

  void setCreated(LocalDateTime created);

  void setDescription(LocalizedStructuredContent description);

  void setLabel(Text label);

  void setLastModified(LocalDateTime lastModified);

  void setIiifImage(IiifImage thumbnail);

  void setType(IdentifiableType identifiableType);

  void setUuid(UUID uuid);
}
