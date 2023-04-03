package de.digitalcollections.model.identifiable.alias;

import static de.digitalcollections.model.time.TimestampHelper.truncatedToMicros;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.identifiable.entity.Website;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
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
  private Identifiable target;
  private Locale targetLanguage;
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
        && Objects.equals(this.target, other.target)
        && Objects.equals(this.targetLanguage, other.targetLanguage)
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
    if (target == null) {
      return null;
    }
    if (IdentifiableType.RESOURCE == target.getType()) {
      return null;
    }
    switch (target.getIdentifiableObjectType()) {
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
        return EntityType.valueOf(target.getIdentifiableObjectType().toString());
    }
  }

  public Identifiable getTarget() {
    return target;
  }

  public Locale getTargetLanguage() {
    return this.targetLanguage;
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
        this.target,
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

  public void setTargetLanguage(Locale targetLanguage) {
    this.targetLanguage = targetLanguage;
  }

  public void setTarget(Identifiable target) {
    this.target = target;
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
        + ", target="
        + target
        + ", targetLanguage="
        + targetLanguage
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

    public B target(Identifiable identifiable) {
      this.target = identifiable;
      return self();
    }

    public B website(Website website) {
      this.website = website;
      return self();
    }
  }
}
