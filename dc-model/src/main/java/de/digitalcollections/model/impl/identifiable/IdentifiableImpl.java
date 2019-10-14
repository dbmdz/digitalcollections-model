package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.Identifier;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class IdentifiableImpl implements Identifiable {

  protected LocalDateTime created;
  protected LocalizedStructuredContent description;
  private List<Identifier> identifiers = new LinkedList<>();
  protected LocalizedText label;
  protected LocalDateTime lastModified;
  protected ImageFileResource previewImage;
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
    if (identifiers == null) {
      identifiers = new ArrayList<>();
    }
    identifiers.add(identifier);
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
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  @Override
  public void setIdentifiers(List<Identifier> identifiers) {
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
}
