package de.digitalcollections.model.identifiable.entity.agent;

import de.digitalcollections.model.identifiable.entity.EntityBuilder;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Text;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class CorporateBodyBuilder extends EntityBuilder<CorporateBody, CorporateBodyBuilder> {

  @Override
  protected EntityType getEntityType() {
    return EntityType.CORPORATE_BODY;
  }

  public CorporateBodyBuilder withHomepageUrl(String homepageUrl) {
    try {
      identifiable.setHomepageUrl(new URL(homepageUrl));
    } catch (MalformedURLException e) {
      throw new RuntimeException("Invalid URL='" + homepageUrl + "': " + e, e);
    }
    return this;
  }

  public CorporateBodyBuilder withText(Locale locale, String localizedText) {
    LocalizedStructuredContent localizedStructuredContent = identifiable.getText();
    if (localizedStructuredContent == null) {
      localizedStructuredContent = new LocalizedStructuredContent();
    }
    StructuredContent textContent = new StructuredContent();
    ContentBlock singleTextContentBlock = new Text(localizedText);
    textContent.setContentBlocks(List.of(singleTextContentBlock));
    localizedStructuredContent.put(locale, textContent);

    identifiable.setText(localizedStructuredContent);
    return this;
  }
}
