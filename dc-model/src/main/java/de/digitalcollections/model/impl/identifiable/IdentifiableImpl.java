package de.digitalcollections.model.impl.identifiable;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiableType;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDateTime;
import java.util.UUID;

public class IdentifiableImpl implements Identifiable {

  private UUID uuid;
  protected LocalDateTime created;
  protected LocalizedStructuredContent description;
  protected LocalizedText label;
  protected LocalDateTime lastModified;
  protected IdentifiableType type;

  @Override
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  @Override
  public LocalDateTime getCreated() {
    return created;
  }

  @Override
  public LocalizedStructuredContent getDescription() {
    return description;
  }

  @Override
  public LocalizedText getLabel() {
    return label;
  }

  @Override
  public LocalDateTime getLastModified() {
    return lastModified;
  }

  @Override
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  @Override
  public void setDescription(LocalizedStructuredContent description) {
    this.description = description;
  }

  @Override
  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  @Override
  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  @Override
  public IdentifiableType getType() {
    return this.type;
  }

  @Override
  public void setType(IdentifiableType identifiableType) {
    this.type = identifiableType;
  }

}
