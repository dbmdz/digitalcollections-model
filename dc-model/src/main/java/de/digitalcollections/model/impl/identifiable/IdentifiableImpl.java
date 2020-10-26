package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.Identifier;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.RenderingHintsPreviewImage;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class IdentifiableImpl implements Identifiable {

  protected LocalDateTime created;
  protected LocalizedStructuredContent description;
  private Set<Identifier> identifiers = new HashSet<>();
  protected LocalizedText label;
  protected LocalDateTime lastModified;
  protected ImageFileResource previewImage;
  protected RenderingHintsPreviewImage previewImageRenderingHints;
  protected IdentifiableType type;
  private UUID uuid;

  @Override
  public LocalDateTime getCreated() {
    return created;
  }

  @Override
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  @Override
  public LocalizedStructuredContent getDescription() {
    return description;
  }

  @Override
  public void setDescription(LocalizedStructuredContent description) {
    this.description = description;
  }

  @Override
  public void addIdentifier(Identifier identifier) {
    identifiers.add(Objects.requireNonNull(identifier));
  }

  @Override
  public Identifier getIdentifierByNamespace(String namespace) {
    if (namespace == null || identifiers == null || identifiers.isEmpty()) {
      return null;
    }
    for (Identifier identifier : identifiers) {
      if (namespace.equals(identifier.getNamespace())) {
        return identifier;
      }
    }
    return null;
  }

  @Override
  public Set<Identifier> getIdentifiers() {
    return identifiers;
  }

  @Override
  public void setIdentifiers(Set<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  @Override
  public LocalizedText getLabel() {
    return label;
  }

  @Override
  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  @Override
  public LocalDateTime getLastModified() {
    return lastModified;
  }

  @Override
  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  @Override
  public ImageFileResource getPreviewImage() {
    return previewImage;
  }

  @Override
  public void setPreviewImage(ImageFileResource previewImage) {
    this.previewImage = previewImage;
  }

  @Override
  public IdentifiableType getType() {
    return this.type;
  }

  @Override
  public void setType(IdentifiableType identifiableType) {
    this.type = identifiableType;
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
  public RenderingHintsPreviewImage getPreviewImageRenderingHints() {
    return previewImageRenderingHints;
  }

  @Override
  public void setPreviewImageRenderingHints(RenderingHintsPreviewImage previewImageRenderingHints) {
    this.previewImageRenderingHints = previewImageRenderingHints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IdentifiableImpl)) {
      return false;
    }
    IdentifiableImpl that = (IdentifiableImpl) o;
    return Objects.equals(created, that.created) &&
        Objects.equals(description, that.description) &&
        Objects.equals(identifiers, that.identifiers) &&
        Objects.equals(label, that.label) &&
        Objects.equals(lastModified, that.lastModified) &&
        Objects.equals(previewImage, that.previewImage) &&
        Objects.equals(previewImageRenderingHints, that.previewImageRenderingHints) &&
        type == that.type &&
        Objects.equals(uuid, that.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, description, identifiers, label, lastModified, previewImage, previewImageRenderingHints, type, uuid);
  }
}
