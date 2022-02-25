package de.digitalcollections.model.legal;

import de.digitalcollections.model.text.LocalizedText;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.UUID;

public class LicenseBuilder {

  private License license;

  public LicenseBuilder() {
    this.license = new License();
  }

  public License build() {
    return license;
  }

  public LicenseBuilder withLabel(Locale locale, String text) {
    license.setLabel(new LocalizedText(locale, text));
    return this;
  }

  public LicenseBuilder withAcronym(String acronym) {
    license.setAcronym(acronym);
    return this;
  }

  public LicenseBuilder withUrl(String url) {
    if (url==null) {
      return this;
    }

    try {
      license.setUrl(new URL(url));
    } catch (MalformedURLException e) {
      throw new RuntimeException("Cannot set url=" + url + ": " + e, e);
    }
    return this;
  }

  public LicenseBuilder withUuid(UUID uuid) {
    license.setUuid(uuid);
    return this;
  }

  public LicenseBuilder withLabel(LocalizedText label) {
    license.setLabel(label);
    return this;
  }
}
