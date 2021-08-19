package de.digitalcollections.model.alias;

import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.entity.EntityType;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class UrlAlias {

  private LocalDateTime created;
  private LocalDateTime lastPublished;
  private boolean mainAlias;
  private String slug;
  private Locale targetLanguage;
  private IdentifiableType targetIdentifiableType;
  private EntityType targetEntityType;
  private UUID targetUuid;
  private UUID uuid;
  private UUID websiteUuid;

  public UrlAlias() {}

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof UrlAlias)) {
      return false;
    }
    UrlAlias other = (UrlAlias) obj;
    return Objects.equals(this.created, other.created)
        && Objects.equals(this.lastPublished, other.lastPublished)
        && this.mainAlias == other.mainAlias
        && Objects.equals(this.slug, other.slug)
        && Objects.equals(this.targetLanguage, other.targetLanguage)
        && Objects.equals(this.targetIdentifiableType, other.targetIdentifiableType)
        && Objects.equals(this.targetEntityType, other.targetEntityType)
        && Objects.equals(this.targetUuid, other.targetUuid)
        && Objects.equals(this.uuid, other.uuid)
        && Objects.equals(this.websiteUuid, other.websiteUuid);
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public LocalDateTime getLastPublished() {
    return this.lastPublished;
  }

  public String getSlug() {
    return this.slug;
  }

  public EntityType getTargetEntityType() {
    return this.targetEntityType;
  }

  public IdentifiableType getTargetIdentifiableType() {
    return this.targetIdentifiableType;
  }

  public Locale getTargetLanguage() {
    return this.targetLanguage;
  }

  public UUID getTargetUuid() {
    return this.targetUuid;
  }

  public UUID getUuid() {
    return this.uuid;
  }

  public UUID getWebsiteUuid() {
    return this.websiteUuid;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.created,
        this.lastPublished,
        this.mainAlias,
        this.slug,
        this.targetLanguage,
        this.targetIdentifiableType,
        this.targetEntityType,
        this.targetUuid,
        this.uuid,
        this.websiteUuid);
  }

  public boolean isMainAlias() {
    return this.mainAlias;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setLastPublished(LocalDateTime lastPublished) {
    this.lastPublished = lastPublished;
  }

  public void setMainAlias(boolean mainAlias) {
    this.mainAlias = mainAlias;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public void setTargetEntityType(EntityType targetEntityType) {
    this.targetEntityType = targetEntityType;
  }

  public void setTargetIdentifiableType(IdentifiableType identifiableType) {
    this.targetIdentifiableType = identifiableType;
  }

  public void setTargetLanguage(Locale targetLanguage) {
    this.targetLanguage = targetLanguage;
  }

  public void setTargetUuid(UUID targetUuid) {
    this.targetUuid = targetUuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public void setWebsiteUuid(UUID websiteUuid) {
    this.websiteUuid = websiteUuid;
  }
}
