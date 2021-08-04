package de.digitalcollections.model.alias;

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
  private EntityType targetType;
  private UUID targetUuid;
  private UUID uuid;
  private UUID website;

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
        && Objects.equals(this.targetType, other.targetType)
        && Objects.equals(this.targetUuid, other.targetUuid)
        && Objects.equals(this.uuid, other.uuid)
        && Objects.equals(this.website, other.website);
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

  public Locale getTargetLanguage() {
    return this.targetLanguage;
  }

  public EntityType getTargetType() {
    return this.targetType;
  }

  public UUID getTargetUuid() {
    return this.targetUuid;
  }

  public UUID getUuid() {
    return this.uuid;
  }

  public UUID getWebsite() {
    return this.website;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.created,
        this.lastPublished,
        this.mainAlias,
        this.slug,
        this.targetLanguage,
        this.targetType,
        this.targetUuid,
        this.uuid,
        this.website);
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

  public void setTargetLanguage(Locale targetLanguage) {
    this.targetLanguage = targetLanguage;
  }

  public void setTargetType(EntityType targetType) {
    this.targetType = targetType;
  }

  public void setTargetUuid(UUID targetUuid) {
    this.targetUuid = targetUuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public void setWebsite(UUID website) {
    this.website = website;
  }
}
