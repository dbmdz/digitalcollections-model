package de.digitalcollections.model.identifiable;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.alias.LocalizedUrlAliases;
import de.digitalcollections.model.identifiable.alias.UrlAlias;
import de.digitalcollections.model.identifiable.entity.Website;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.view.RenderingHintsPreviewImage;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

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
public class Identifiable extends UniqueObject {

  protected LocalizedStructuredContent description;
  protected Set<Identifier> identifiers = new HashSet<>();
  protected LocalizedText label;
  protected LocalizedUrlAliases localizedUrlAliases;
  protected ImageFileResource previewImage;
  protected RenderingHintsPreviewImage previewImageRenderingHints;
  protected IdentifiableType type;

  public void addIdentifier(Identifier identifier) {
    identifiers.add(Objects.requireNonNull(identifier));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Identifiable)) {
      return false;
    }
    Identifiable that = (Identifiable) o;
    return Objects.equals(created, that.created)
        && Objects.equals(description, that.description)
        && Objects.equals(identifiers, that.identifiers)
        && Objects.equals(label, that.label)
        && Objects.equals(lastModified, that.lastModified)
        && Objects.equals(localizedUrlAliases, that.localizedUrlAliases)
        && Objects.equals(previewImage, that.previewImage)
        && Objects.equals(previewImageRenderingHints, that.previewImageRenderingHints)
        && type == that.type
        && Objects.equals(uuid, that.uuid);
  }

  public LocalizedStructuredContent getDescription() {
    return description;
  }

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

  public Set<Identifier> getIdentifiers() {
    return identifiers;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public LocalizedUrlAliases getLocalizedUrlAliases() {
    return localizedUrlAliases;
  }

  public ImageFileResource getPreviewImage() {
    return previewImage;
  }

  public RenderingHintsPreviewImage getPreviewImageRenderingHints() {
    return previewImageRenderingHints;
  }

  /**
   * Returns the primary (= currently active) url alias of this Identifiable for a specified
   * language and website. If no related url alias is found the website independent url alias of the
   * given locale is returned (that has been generated during saving from the Identifiable's label).
   *
   * @param locale target locale for retrieving primary url alias
   * @param website target website for retrieving primary url alias
   * @return primary url alias for website and locale or default
   */
  public UrlAlias getPrimaryUrlAlias(Locale locale, Website website) {
    // check if there are any url aliases at all
    if (localizedUrlAliases == null || localizedUrlAliases.isEmpty()) {
      return null;
    }
    List<UrlAlias> urlAliases =
        localizedUrlAliases.get(Locale.forLanguageTag(locale.getLanguage()));
    // check if there are url aliases for the given language
    if (urlAliases == null || urlAliases.isEmpty()) {
      return null;
    }
    Supplier<Stream<UrlAlias>> primaries = () -> urlAliases.stream().filter(u -> u.isPrimary());
    if (website != null) {
      UrlAlias urlAlias =
          primaries
              .get()
              .filter(
                  u -> u.getWebsite() != null && u.getWebsite().getUuid().equals(website.getUuid()))
              .findFirst()
              .orElse(null);
      // given website found, return it
      if (urlAlias != null) {
        return urlAlias;
      }
    }
    // no given website or given website not found, use default alias
    return primaries.get().filter(u -> u.getWebsite() == null).findFirst().orElse(null);
  }

  public IdentifiableType getType() {
    return this.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        created,
        description,
        identifiers,
        label,
        lastModified,
        localizedUrlAliases,
        previewImage,
        previewImageRenderingHints,
        type,
        uuid);
  }

  public void setDescription(LocalizedStructuredContent description) {
    this.description = description;
  }

  public void setIdentifiers(Set<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  public void setLabel(String label) {
    this.label = new LocalizedText(Locale.ROOT, label);
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setLocalizedUrlAliases(LocalizedUrlAliases localizedUrlAliases) {
    this.localizedUrlAliases = localizedUrlAliases;
  }

  public void setPreviewImage(ImageFileResource previewImage) {
    this.previewImage = previewImage;
  }

  public void setPreviewImageRenderingHints(RenderingHintsPreviewImage previewImageRenderingHints) {
    this.previewImageRenderingHints = previewImageRenderingHints;
  }

  public void setType(IdentifiableType identifiableType) {
    this.type = identifiableType;
  }
}
