package de.digitalcollections.model.identifiable.alias;

import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.identifiable.entity.Website;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/**
 * A website and language specific "alias" (= human readable unique key) used as relative url part
 * for a website specific domain. The absolute URL references an Identifiable, e.g. a specific
 * webpage or collection.
 */
public class UrlAlias {

  private LocalDateTime created;
  private LocalDateTime lastPublished;
  private boolean primary;
  private String slug;
  private EntityType targetEntityType;
  private IdentifiableType targetIdentifiableType;
  private Locale targetLanguage;
  private UUID targetUuid;
  private UUID uuid;
  private Website website;

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
        && this.primary == other.primary
        && Objects.equals(this.slug, other.slug)
        && Objects.equals(this.targetLanguage, other.targetLanguage)
        && Objects.equals(this.targetIdentifiableType, other.targetIdentifiableType)
        && Objects.equals(this.targetEntityType, other.targetEntityType)
        && Objects.equals(this.targetUuid, other.targetUuid)
        && Objects.equals(this.uuid, other.uuid)
        && Objects.equals(
            this.website != null ? this.website.getUuid() : null,
            other.website != null ? other.website.getUuid() : null);
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

  public Website getWebsite() {
    return this.website;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.created,
        this.lastPublished,
        this.primary,
        this.slug,
        this.targetLanguage,
        this.targetIdentifiableType,
        this.targetEntityType,
        this.targetUuid,
        this.uuid,
        this.website);
  }

  public boolean isPrimary() {
    return this.primary;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setLastPublished(LocalDateTime lastPublished) {
    this.lastPublished = lastPublished;
  }

  public void setPrimary(boolean primary) {
    this.primary = primary;
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

  public void setWebsite(Website website) {
    this.website = website;
  }
}
