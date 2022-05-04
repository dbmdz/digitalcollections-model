package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import lombok.experimental.SuperBuilder;

/**
 * CorporateBody is used to describe a (business) corporation (e.g. a project partner or
 * organization or creator of a work). See
 * https://de.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records and
 * http://www.ib.hu-berlin.de/~kumlau/handreichungen/h189/#auf
 */
@SuperBuilder(buildMethodName = "prebuild")
public class CorporateBody extends Agent {

  private URL homepageUrl;

  private LocalizedStructuredContent text;

  public CorporateBody() {
    super();
    this.entityType = EntityType.CORPORATE_BODY;
  }

  /**
   * @return URL to homepage of corporate body
   */
  public URL getHomepageUrl() {
    return homepageUrl;
  }

  /**
   * @return localized formatted text describing corporate body
   */
  public LocalizedStructuredContent getText() {
    return text;
  }

  /**
   * @param homepageUrl set URL to homepage of corporate body
   */
  public void setHomepageUrl(URL homepageUrl) {
    this.homepageUrl = homepageUrl;
  }

  /**
   * @param text set localized formatted text describing corporate body
   */
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "CorporateBody{"
        + "created="
        + created
        + ", lastModified="
        + lastModified
        + ", uuid="
        + uuid
        + ", description="
        + description
        + ", identifiers="
        + identifiers
        + ", label="
        + label
        + ", localizedUrlAliases="
        + localizedUrlAliases
        + ", previewImage="
        + previewImage
        + ", previewImageRenderingHints="
        + previewImageRenderingHints
        + ", type="
        + type
        + ", customAttributes="
        + customAttributes
        + ", entityType="
        + entityType
        + ", navDate="
        + navDate
        + ", refId="
        + refId
        + ", homepageUrl="
        + homepageUrl
        + ", text="
        + text
        + "}@"
        + hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CorporateBody)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    CorporateBody that = (CorporateBody) o;
    return Objects.equals(homepageUrl, that.homepageUrl) && Objects.equals(text, that.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), homepageUrl, text);
  }

  public abstract static class CorporateBodyBuilder<
          C extends CorporateBody, B extends CorporateBodyBuilder<C, B>>
      extends AgentBuilder<C, B> {

    public B text(Locale locale, String text) {
      if (this.text == null) {
        this.text = new LocalizedStructuredContent();
      }
      StructuredContent localizedDescription = this.text.get(locale);
      if (localizedDescription == null) {
        localizedDescription = new StructuredContent();
      }
      ContentBlock paragraph =
          text != null && text.isBlank() ? new Paragraph(text) : new Paragraph();
      localizedDescription.addContentBlock(paragraph);
      this.text.put(locale, localizedDescription);
      return self();
    }

    public B homepageUrl(String homepageUrl) {
      try {
        this.homepageUrl = new URL(homepageUrl);
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
      return self();
    }

    public B homepageUrl(URL homepageUrl) {
      this.homepageUrl = homepageUrl;
      return self();
    }

    @Override
    public C build() {
      C c = prebuild();
      c.setType(IdentifiableType.ENTITY);
      c.setEntityType(EntityType.CORPORATE_BODY);
      setInternalReferences(c);
      return c;
    }
  }
}
