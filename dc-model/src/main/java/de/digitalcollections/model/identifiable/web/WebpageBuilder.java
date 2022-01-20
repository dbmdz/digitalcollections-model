package de.digitalcollections.model.identifiable.web;

import de.digitalcollections.model.file.MimeType;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.identifiable.resource.PreviewImageBuilder;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.text.contentblock.ParagraphBuilder;
import de.digitalcollections.model.view.RenderingHints;
import de.digitalcollections.model.view.RenderingHintsPreviewImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.LocaleUtils;

public class WebpageBuilder {

  Webpage webpage = new Webpage();

  public Webpage build() {
    return webpage;
  }

  public WebpageBuilder createdAt(String created) {
    webpage.setCreated(LocalDateTime.parse(created));
    return this;
  }

  public WebpageBuilder lastModifiedAt(String lastModified) {
    webpage.setLastModified(LocalDateTime.parse(lastModified));
    return this;
  }

  public WebpageBuilder setIdentifiers(Set<Identifier> identifiers) {
    webpage.setIdentifiers(identifiers);
    return this;
  }

  public WebpageBuilder withLabel(Locale locale, String localizedLabel) {
    LocalizedText label = webpage.getLabel();
    if (label == null) {
      label = new LocalizedText();
    }
    label.setText(locale, localizedLabel);
    webpage.setLabel(label);
    return this;
  }

  public WebpageBuilder withUuid(String uuidStr) {
    webpage.setUuid(UUID.fromString(uuidStr));
    return this;
  }

  public WebpageBuilder withPublicationStartAt(String publicationStart) {
    webpage.setPublicationStart(LocalDate.parse(publicationStart));
    return this;
  }

  public WebpageBuilder withDescription(String locale, String text) {
    LocalizedStructuredContent description = webpage.getDescription();
    if (description == null) {
      description = new LocalizedStructuredContent();
    }
    StructuredContent localizedDescription = description.get(locale);
    if (localizedDescription == null) {
      localizedDescription = new StructuredContent();
    }
    ContentBlock paragraph =
        (text != null && text.length() > 0) ? new Paragraph(text) : new Paragraph();
    localizedDescription.addContentBlock(paragraph);
    description.put(LocaleUtils.toLocale(locale), localizedDescription);
    webpage.setDescription(description);
    return this;
  }

  public WebpageBuilder shownInNavigation() {
    RenderingHints renderingHints = new RenderingHints();
    renderingHints.setShowInPageNavigation(true);
    webpage.setRenderingHints(renderingHints);
    return this;
  }

  public WebpageBuilder notShownInNavigation() {
    RenderingHints renderingHints = new RenderingHints();
    renderingHints.setShowInPageNavigation(false);
    webpage.setRenderingHints(renderingHints);
    return this;
  }

  public WebpageBuilder withPreviewImage(
      String fileName, String uuid, String uri, MimeType mimeType, String httpBaseUrl) {
    ImageFileResource previewImage =
        new PreviewImageBuilder(uuid)
            .withFileName(fileName)
            .withUri(uri)
            .withMimeType(mimeType)
            .withHttpBaseUrl(httpBaseUrl)
            .build();
    webpage.setPreviewImage(previewImage);
    return this;
  }

  public WebpageBuilder withAltText(Locale locale, String text) {
    RenderingHintsPreviewImage previewImageRenderingHints = webpage.getPreviewImageRenderingHints();
    if (previewImageRenderingHints == null) {
      previewImageRenderingHints = new RenderingHintsPreviewImage();
    }
    previewImageRenderingHints.setAltText(new LocalizedText(locale, text));
    webpage.setPreviewImageRenderingHints(previewImageRenderingHints);
    return this;
  }

  public WebpageBuilder withOpenLinkInNewWindow() {
    RenderingHintsPreviewImage previewImageRenderingHints = webpage.getPreviewImageRenderingHints();
    if (previewImageRenderingHints == null) {
      previewImageRenderingHints = new RenderingHintsPreviewImage();
    }
    previewImageRenderingHints.setOpenLinkInNewWindow(true);
    webpage.setPreviewImageRenderingHints(previewImageRenderingHints);
    return this;
  }

  public WebpageBuilder withTemplateName(String templateName) {
    RenderingHints renderingHints = webpage.getRenderingHints();
    if (renderingHints == null) {
      renderingHints = new RenderingHints();
    }
    renderingHints.setTemplateName(templateName);
    webpage.setRenderingHints(renderingHints);
    return this;
  }

  public WebpageBuilder withChildren(List<Webpage> children) {
    webpage.setChildren(children);
    return this;
  }

  public static Webpage createPrefilledWebpage(String path) {
    LocalizedStructuredContent content = new LocalizedStructuredContent();
    StructuredContent structuredContentDe = new StructuredContent();
    structuredContentDe.addContentBlock(
        new ParagraphBuilder()
            .addText("Acme", "strong")
            .addText(
                "                                                                                              ")
            .addText(
                "                                                                           ",
                "strong")
            .addText(
                "                                                                                                                       Ludwigstraße 16")
            .addHardBreak()
            .addText("12345 Ort")
            .build());
    structuredContentDe.addContentBlock(
        new ParagraphBuilder().addText("Gesetzlicher Vertreter:", "strong").build());
    structuredContentDe.addContentBlock(new ParagraphBuilder().addText("xxx").build());
    structuredContentDe.addContentBlock(
        new ParagraphBuilder()
            .addText("Telefon: ", "strong")
            .addText("12345")
            .addHardBreak()
            .addText("Fax: ", "strong")
            .addText("67890")
            .build());
    structuredContentDe.addContentBlock(
        new ParagraphBuilder()
            .addText("E-Mail: ", "strong")
            .addText("xxx@xxx.xxx")
            .addHardBreak()
            .addText(
                "                                                                                                                                                                                                                                                              ")
            .addText(
                "                       Internet:                                                   ",
                "strong")
            .addText(
                "                                                                                                                                                                                                                                                       ")
            .addLink(
                "                                             www.xxx.xxx", "https://www.xxx.xxx/")
            .addText(
                "                                                                                        ")
            .addHardBreak()
            .addText(
                "                                                                                                                                                                                                                                                              ")
            .addText("                       Umsatzsteueridentifikationsnummer: ", "strong")
            .addText("DE-1234567                              ")
            .build());
    structuredContentDe.addContentBlock(
        new ParagraphBuilder()
            .addText("Acme ist eine ")
            .addLinkWithTitle("Testinstitution", "https://localhost/", "")
            .addText("  mit Sitz irgendwo.                               ")
            .build());
    content.put(Locale.GERMAN, structuredContentDe);
    content.put(Locale.ENGLISH, new StructuredContent());

    Webpage webpage = new Webpage();
    webpage.setText(content);
    webpage.setLabel(new LocalizedText(Locale.forLanguageTag("de"), "Impressum"));
    webpage.setUuid(extractFirstUuidFromPath(path));
    webpage.setPublicationStart(LocalDate.parse("2019-01-18"));
    webpage.setType(IdentifiableType.ENTITY);
    webpage.setChildren(List.of());
    webpage.setCreated(LocalDateTime.parse("2019-01-16T10:06:31.747"));
    webpage.setLastModified(LocalDateTime.parse("2019-01-18T10:26:17.527"));

    return webpage;
  }

  private static UUID extractFirstUuidFromPath(String path) {
    Pattern uuidPattern =
        Pattern.compile("(\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12})");
    Matcher matcher = uuidPattern.matcher(path);
    if (matcher.find()) {
      return UUID.fromString(matcher.group(0));
    }
    return null;
  }
}
