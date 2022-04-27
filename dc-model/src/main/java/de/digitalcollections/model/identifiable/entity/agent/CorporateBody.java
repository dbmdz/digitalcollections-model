package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Text;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * CorporateBody is used to describe a (business) corporation (e.g. a project partner or
 * organization or creator of a work). See
 * https://de.wikipedia.org/wiki/Functional_Requirements_for_Bibliographic_Records and
 * http://www.ib.hu-berlin.de/~kumlau/handreichungen/h189/#auf
 */
public class CorporateBody extends Agent {

  private URL homepageUrl;

  private LocalizedStructuredContent text;

  public CorporateBody() {
    super();
    this.entityType = EntityType.CORPORATE_BODY;
  }

  /** @return URL to homepage of corporate body */
  public URL getHomepageUrl() {
    return homepageUrl;
  }

  /** @return localized formatted text describing corporate body */
  public LocalizedStructuredContent getText() {
    return text;
  }

  /** @param homepageUrl set URL to homepage of corporate body */
  public void setHomepageUrl(URL homepageUrl) {
    this.homepageUrl = homepageUrl;
  }

  /** @param text set localized formatted text describing corporate body */
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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends Agent.Builder<CorporateBody, Builder> {

    @Override
    protected EntityType getEntityType() {
      return EntityType.CORPORATE_BODY;
    }

    public Builder withHomepageUrl(String homepageUrl) {
      try {
        ((CorporateBody)identifiable).setHomepageUrl(new URL(homepageUrl));
      } catch (MalformedURLException e) {
        throw new RuntimeException("Invalid URL='" + homepageUrl + "': " + e, e);
      }
      return this;
    }

    public Builder withText(Locale locale, String localizedText) {
      LocalizedStructuredContent localizedStructuredContent = ((CorporateBody)identifiable).getText();
      if (localizedStructuredContent == null) {
        localizedStructuredContent = new LocalizedStructuredContent();
      }
      StructuredContent textContent = new StructuredContent();
      ContentBlock singleTextContentBlock = new Text(localizedText);
      textContent.setContentBlocks(List.of(singleTextContentBlock));
      localizedStructuredContent.put(locale, textContent);

      ((CorporateBody)identifiable).setText(localizedStructuredContent);
      return this;
    }
  }
}
