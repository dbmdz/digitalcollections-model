package de.digitalcollections.model.api.identifiable;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface Identifiable {

  LocalDateTime getCreated();

  void setCreated(LocalDateTime created);

  LocalizedStructuredContent getDescription();

  void setDescription(LocalizedStructuredContent description);

  void addIdentifier(Identifier identifier);

  List<Identifier> getIdentifiers();

  void setIdentifiers(List<Identifier> identifiers);

  Identifier getIdentifierByNamespace(String namespace);

  LocalizedText getLabel();

  void setLabel(LocalizedText label);

  LocalDateTime getLastModified();

  void setLastModified(LocalDateTime lastModified);

  ImageFileResource getPreviewImage();

  void setPreviewImage(ImageFileResource previewImage);

  IdentifiableType getType();

  void setType(IdentifiableType identifiableType);

  UUID getUuid();

  void setUuid(UUID uuid);
}
