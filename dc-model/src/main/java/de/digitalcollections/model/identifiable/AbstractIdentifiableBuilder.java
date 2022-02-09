package de.digitalcollections.model.identifiable;

import de.digitalcollections.model.file.MimeType;
import de.digitalcollections.model.identifiable.alias.LocalizedUrlAliases;
import de.digitalcollections.model.identifiable.alias.UrlAliasBuilder;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.identifiable.resource.PreviewImageBuilder;
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
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

public abstract class AbstractIdentifiableBuilder<
    I extends Identifiable, B extends AbstractIdentifiableBuilder> {

  protected I identifiable;
  Set<Identifier> identifiers;
  private final Class<I> identifiableType;

  public AbstractIdentifiableBuilder() {
    identifiableType =
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

  protected abstract IdentifiableType getIdentifiableType();

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
        new PreviewImageBuilder()
            .withFileName(fileNameParts[fileNameParts.length - 1])
            .withUri(url)
            .withSize(width, height)
            .build();

    identifiable.setPreviewImage(previewImage);
    return (B) this;
  }

  public B withPreviewImage(String fileName, String uuid, String uri) {
    ImageFileResource previewImage =
        new PreviewImageBuilder(uuid).withFileName(fileName).withUri(uri).build();
    identifiable.setPreviewImage(previewImage);
    return (B) this;
  }

  public B withPreviewImage(String fileName, String uuid, String uri, MimeType mimeType) {
    ImageFileResource previewImage =
        new PreviewImageBuilder(uuid)
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
        new PreviewImageBuilder(uuid)
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

  public B withPrimaryLocalizedUrlAlias(String slug) {
    LocalizedUrlAliases localizedUrlAliases =
        new LocalizedUrlAliasesBuilder()
            .addUrlAlias(new UrlAliasBuilder().withSlug(slug).isPrimary().build())
            .build();

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
