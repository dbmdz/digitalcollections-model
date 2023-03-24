package de.digitalcollections.model.identifiable.alias;

import static de.digitalcollections.model.time.TimestampHelper.truncatedToMicros;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.IdentifiableObjectType;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.identifiable.entity.Website;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import lombok.experimental.SuperBuilder;

/**
 * A website and language specific "alias" (= human readable unique key) used as relative url part
 * for a website specific domain. The absolute URL references an Identifiable, e.g. a specific
 * webpage or collection.
 */
@SuperBuilder(buildMethodName = "prebuild")
public class UrlAlias extends UniqueObject {

  private LocalDateTime lastPublished;
  private boolean primary;
  private String slug;
  private IdentifiableObjectType targetIdentifiableObjectType;
  private IdentifiableType targetIdentifiableType;
  private Locale targetLanguage;
  private UUID targetUuid;
  private Website website;

  public UrlAlias() {
    super();
  }

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
        && Objects.equals(this.lastModified, other.lastModified)
        && Objects.equals(this.lastPublished, other.lastPublished)
        && this.primary == other.primary
        && Objects.equals(this.slug, other.slug)
        && Objects.equals(this.targetLanguage, other.targetLanguage)
        && Objects.equals(this.targetIdentifiableObjectType, other.targetIdentifiableObjectType)
        && Objects.equals(this.targetIdentifiableType, other.targetIdentifiableType)
        && Objects.equals(this.targetUuid, other.targetUuid)
        && Objects.equals(this.uuid, other.uuid)
        && Objects.equals(
            this.website != null ? this.website.getUuid() : null,
            other.website != null ? other.website.getUuid() : null);
  }

  public LocalDateTime getLastPublished() {
    return this.lastPublished;
  }

  public String getSlug() {
    return this.slug;
  }

  @Deprecated(forRemoval = true, since = "10.0.0")
  public EntityType getTargetEntityType() {
    if (IdentifiableType.RESOURCE == targetIdentifiableType) {
      return null;
    }
    switch (targetIdentifiableObjectType) {
      case CANYON:
      case CAVE:
      case CONTINENT:
      case COUNTRY:
      case CREEK:
      case GEO_LOCATION:
      case HUMAN_SETTLEMENT:
      case LAKE:
      case MOUNTAIN:
      case OCEAN:
      case RIVER:
      case SEA:
      case STILL_WATERS:
      case VALLEY:
        return EntityType.GEOLOCATION;
      default:
        // as both enum have String identical enum values in all other cases, we can simply map by
        // String:
        return EntityType.valueOf(targetIdentifiableObjectType.toString());
    }
  }

  public IdentifiableObjectType getTargetIdentifiableObjectType() {
    return targetIdentifiableObjectType;
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

  public Website getWebsite() {
    return this.website;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.created,
        this.lastModified,
        this.lastPublished,
        this.primary,
        this.slug,
        this.targetLanguage,
        this.targetIdentifiableObjectType,
        this.targetIdentifiableType,
        this.targetUuid,
        this.uuid,
        this.website);
  }

  @Override
  protected void init() {
    super.init();
  }

  public boolean isPrimary() {
    return this.primary;
  }

  public void setLastPublished(LocalDateTime lastPublished) {
    this.lastPublished = truncatedToMicros(lastPublished);
  }

  public void setPrimary(boolean primary) {
    this.primary = primary;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public void setTargetIdentifiableObjectType(IdentifiableObjectType targetIdentifiableObjectType) {
    this.targetIdentifiableObjectType = targetIdentifiableObjectType;
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

  public void setWebsite(Website website) {
    this.website = website;
  }

  @Override
  public String toString() {
    return "UrlAlias{"
        + "created="
        + created
        + ", lastModified="
        + lastModified
        + ", lastPublished="
        + lastPublished
        + ", primary="
        + primary
        + ", slug='"
        + slug
        + '\''
        + ", targetIdentifiableObjectType="
        + targetIdentifiableObjectType
        + ", targetIdentifiableType="
        + targetIdentifiableType
        + ", targetLanguage="
        + targetLanguage
        + ", targetUuid="
        + targetUuid
        + ", uuid="
        + uuid
        + ", website="
        + website
        + '}';
  }

  public abstract static class UrlAliasBuilder<C extends UrlAlias, B extends UrlAliasBuilder<C, B>>
      extends UniqueObjectBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }

    public B isPrimary() {
      this.primary = true;
      return self();
    }

    public B lastPublished(String lastPublished) {
      this.lastPublished = LocalDateTime.parse(lastPublished);
      return self();
    }

    public B slug(String slug) {
      this.slug = slug;
      return self();
    }

    public B targetLanguage(Locale targetLanguage) {
      this.targetLanguage = targetLanguage;
      return self();
    }

    public B targetLanguage(String targetLanguage) {
      this.targetLanguage = Locale.forLanguageTag(targetLanguage);
      return self();
    }

    public B targetType(
        IdentifiableObjectType identifiableObjectType, IdentifiableType identifiableType) {
      this.targetIdentifiableObjectType = identifiableObjectType;
      this.targetIdentifiableType = identifiableType;
      return self();
    }

    public B targetUuid(String targetUuid) {
      this.targetUuid = UUID.fromString(targetUuid);
      return self();
    }

    public B website(Website website) {
      this.website = website;
      return self();
    }
  }
}
