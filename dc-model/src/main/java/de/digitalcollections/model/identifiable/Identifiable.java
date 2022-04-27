package de.digitalcollections.model.identifiable;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.file.MimeType;
import de.digitalcollections.model.identifiable.alias.LocalizedUrlAliases;
import de.digitalcollections.model.identifiable.alias.UrlAlias;
import de.digitalcollections.model.identifiable.entity.Website;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.view.RenderingHintsPreviewImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.util.StringUtils;

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

  public static Builder builder() {
    return new Builder<>();
  }

  public static class Builder<I extends Identifiable, B extends Builder> {

    protected I identifiable;
    private Set<Identifier> identifiers;

    public Builder() {
      Class<I> identifiableType =
          (Class<I>)
              ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
      try {
        identifiable = identifiableType.getDeclaredConstructor().newInstance();
      } catch (InstantiationException
          | IllegalAccessException
          | InvocationTargetException
          | NoSuchMethodException e) {
        throw new RuntimeException(
            "Cannot create new instance of " + identifiableType.getName() + ": " + e, e);
      }

      identifiable.setType(getIdentifiableType());
    }

    protected IdentifiableType getIdentifiableType() {
      return null;
    }

    public B withUuid(String uuid) {
      identifiable.setUuid(UUID.fromString(uuid));
      return (B) this;
    }

    public B withUuid(UUID uuid) {
      identifiable.setUuid(uuid);
      return (B) this;
    }

    public B withRandomUuid() {
      identifiable.setUuid(UUID.randomUUID());
      return (B) this;
    }

    public B createdAt(String createdAt) {
      identifiable.setCreated(LocalDateTime.parse(createdAt));
      return (B) this;
    }

    public B createdAt(LocalDateTime createdAt) {
      identifiable.setCreated(createdAt);
      return (B) this;
    }

    public B lastModifiedAt(String lastModifiedAt) {
      identifiable.setLastModified(LocalDateTime.parse(lastModifiedAt));
      return (B) this;
    }

    public B lastModifiedAt(LocalDateTime lastModifiedAt) {
      identifiable.setLastModified(lastModifiedAt);
      return (B) this;
    }

    public B withIdentifier(String namespace, String id, String uuid) {
      if (identifiers == null) {
        identifiers = new HashSet<>();
      }
      Identifier identifier = new Identifier();
      identifier.setNamespace(namespace);
      identifier.setId(id);
      if (uuid != null) {
        identifier.setUuid(UUID.fromString(uuid));
      }
      identifiers.add(identifier);
      return (B) this;
    }

    public B withIdentifier(String namespace, String id) {
      return withIdentifier(namespace, id, null);
    }

    public B withLabel(Locale locale, String localizedLabel) {
      LocalizedText label = identifiable.getLabel();
      if (label == null) {
        label = new LocalizedText();
      }
      label.setText(locale, localizedLabel);
      identifiable.setLabel(label);
      return (B) this;
    }

    public B withLabel(String nonlocalizedLabel) {
      identifiable.setLabel(nonlocalizedLabel);
      return (B) this;
    }

    public B withPreviewImage(ImageFileResource previewImage) {
      identifiable.setPreviewImage(previewImage);
      return (B) this;
    }

    public B withPreviewImage(String url, int width, int height) {
      String[] fileNameParts = url.split("/\\//");
      ImageFileResource previewImage =
          ImageFileResource.previewImageBuilder()
              .withFileName(fileNameParts[fileNameParts.length - 1])
              .withUri(url)
              .withSize(width, height)
              .build();

      identifiable.setPreviewImage(previewImage);
      return (B) this;
    }

    public B withPreviewImage(String fileName, String uuid, String uri) {
      ImageFileResource previewImage =
          ImageFileResource.previewImageBuilder()
              .withUuid(uuid)
              .withFileName(fileName)
              .withUri(uri)
              .build();
      identifiable.setPreviewImage(previewImage);
      return (B) this;
    }

    public B withPreviewImage(String fileName, String uuid, String uri, MimeType mimeType) {
      ImageFileResource previewImage =
          ImageFileResource.previewImageBuilder()
              .withUuid(uuid)
              .withFileName(fileName)
              .withUri(uri)
              .withMimeType(mimeType)
              .build();
      identifiable.setPreviewImage(previewImage);
      return (B) this;
    }

    public B withPreviewImage(
        String fileName, String uuid, String uri, MimeType mimeType, String httpBaseUrl) {
      ImageFileResource previewImage =
          ImageFileResource.previewImageBuilder()
              .withUuid(uuid)
              .withFileName(fileName)
              .withUri(uri)
              .withMimeType(mimeType)
              .withHttpBaseUrl(httpBaseUrl)
              .build();
      identifiable.setPreviewImage(previewImage);
      return (B) this;
    }

    public B withOpenPreviewImageInNewWindow() {
      RenderingHintsPreviewImage previewImageRenderingHints =
          identifiable.getPreviewImageRenderingHints();
      if (previewImageRenderingHints == null) {
        previewImageRenderingHints = new RenderingHintsPreviewImage();
      }
      previewImageRenderingHints.setOpenLinkInNewWindow(true);
      identifiable.setPreviewImageRenderingHints(previewImageRenderingHints);
      return (B) this;
    }

    public B withoutOpenPreviewInNewWindow() {
      RenderingHintsPreviewImage previewImageRenderingHints =
          identifiable.getPreviewImageRenderingHints();
      if (previewImageRenderingHints == null) {
        previewImageRenderingHints = new RenderingHintsPreviewImage();
      }
      previewImageRenderingHints.setOpenLinkInNewWindow(false);
      identifiable.setPreviewImageRenderingHints(previewImageRenderingHints);
      return (B) this;
    }

    public B withAltTextFromLabel() {
      RenderingHintsPreviewImage previewImageRenderingHints =
          identifiable.getPreviewImageRenderingHints();
      if (previewImageRenderingHints == null) {
        previewImageRenderingHints = new RenderingHintsPreviewImage();
      }
      previewImageRenderingHints.setAltText(identifiable.getLabel());
      identifiable.setPreviewImageRenderingHints(previewImageRenderingHints);
      return (B) this;
    }

    public B withAltText(Locale locale, String text) {
      RenderingHintsPreviewImage previewImageRenderingHints =
          identifiable.getPreviewImageRenderingHints();
      if (previewImageRenderingHints == null) {
        previewImageRenderingHints = new RenderingHintsPreviewImage();
      }
      LocalizedText altText = previewImageRenderingHints.getAltText();
      if (altText == null) {
        altText = new LocalizedText();
      }
      altText.setText(locale, text);
      previewImageRenderingHints.setAltText(altText);
      identifiable.setPreviewImageRenderingHints(previewImageRenderingHints);
      return (B) this;
    }

    public B withTitleFromLabel() {
      RenderingHintsPreviewImage previewImageRenderingHints =
          identifiable.getPreviewImageRenderingHints();
      if (previewImageRenderingHints == null) {
        previewImageRenderingHints = new RenderingHintsPreviewImage();
      }
      previewImageRenderingHints.setTitle(identifiable.getLabel());
      identifiable.setPreviewImageRenderingHints(previewImageRenderingHints);
      return (B) this;
    }

    public B withTitle(Locale locale, String text) {
      RenderingHintsPreviewImage previewImageRenderingHints =
          identifiable.getPreviewImageRenderingHints();
      if (previewImageRenderingHints == null) {
        previewImageRenderingHints = new RenderingHintsPreviewImage();
      }
      LocalizedText title = previewImageRenderingHints.getTitle();
      if (title == null) {
        title = new LocalizedText();
      }
      title.setText(locale, text);
      previewImageRenderingHints.setTitle(title);
      identifiable.setPreviewImageRenderingHints(previewImageRenderingHints);
      return (B) this;
    }

    public B withDescription(Locale locale, String text) {
      LocalizedStructuredContent description = identifiable.getDescription();
      if (description == null) {
        description = new LocalizedStructuredContent();
      }
      StructuredContent localizedDescription = description.get(locale);
      if (localizedDescription == null) {
        localizedDescription = new StructuredContent();
      }
      ContentBlock paragraph = StringUtils.hasText(text) ? new Paragraph(text) : new Paragraph();
      localizedDescription.addContentBlock(paragraph);
      description.put(locale, localizedDescription);
      identifiable.setDescription(description);
      return (B) this;
    }

    public B withDescription(String language, String text) {
      return withDescription(Locale.forLanguageTag(language), text);
    }

    public B withPrimaryLocalizedUrlAlias(String slug) {
      LocalizedUrlAliases localizedUrlAliases =
          new LocalizedUrlAliases(UrlAlias.builder().withSlug(slug).isPrimary().build());

      identifiable.setLocalizedUrlAliases(localizedUrlAliases);
      return (B) this;
    }

    public I build() {
      // Each identifier must get the UUID of the identifiable
      if (identifiers != null && !identifiers.isEmpty()) {
        identifiable.setIdentifiers(
            identifiers.stream()
                .peek(i -> i.setIdentifiable(identifiable.getUuid()))
                .collect(Collectors.toSet()));
      }

      // For each UrlAlias, the target UUID must be set to the UUID of the identifiable
      if (identifiable.getLocalizedUrlAliases() != null
          && !identifiable.getLocalizedUrlAliases().isEmpty()) {
        identifiable
            .getLocalizedUrlAliases()
            .forEach(
                (locale, urlAliasList) -> {
                  urlAliasList.forEach(u -> u.setTargetUuid(identifiable.getUuid()));
                });
      }
      return identifiable;
    }
  }
}
