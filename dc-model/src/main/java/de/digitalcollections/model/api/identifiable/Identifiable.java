package de.digitalcollections.model.api.identifiable;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.RenderingHintsPreviewImage;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * An Identifiable is an uniquely identifiable {@link
 * de.digitalcollections.model.api.identifiable.entity.Entity} or {@link
 * de.digitalcollections.model.api.identifiable.resource.FileResource}, having one or more unique
 * {@link Identifier}(s).<br>
 *
 * <ul>
 *   <li>FileResources have one (or more) technical (system wide) Identifiers (e.g. an UUID)
 *   <li>Entities additionally have one (or more) “domain-specific” (system independent) Identifiers
 *       (e.g. GND-ID, VIAF-ID)
 * </ul>
 */
public interface Identifiable {

  LocalDateTime getCreated();

  void setCreated(LocalDateTime created);

  LocalizedStructuredContent getDescription();

  void setDescription(LocalizedStructuredContent description);

  void addIdentifier(Identifier identifier);

  Set<Identifier> getIdentifiers();

  void setIdentifiers(Set<Identifier> identifiers);

  Identifier getIdentifierByNamespace(String namespace);

  LocalizedText getLabel();

  void setLabel(LocalizedText label);

  LocalDateTime getLastModified();

  void setLastModified(LocalDateTime lastModified);

  ImageFileResource getPreviewImage();

  void setPreviewImage(ImageFileResource previewImage);

  RenderingHintsPreviewImage getPreviewImageRenderingHints();

  void setPreviewImageRenderingHints(RenderingHintsPreviewImage previewImageRenderingHints);

  IdentifiableType getType();

  void setType(IdentifiableType identifiableType);

  UUID getUuid();

  void setUuid(UUID uuid);
}
