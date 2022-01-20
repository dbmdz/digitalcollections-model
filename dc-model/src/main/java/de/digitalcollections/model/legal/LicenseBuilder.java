package de.digitalcollections.model.legal;

import de.digitalcollections.model.text.LocalizedText;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

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
    try {
      license.setUrl(new URL(url));
    } catch (MalformedURLException e) {
      throw new RuntimeException("Cannot set url=" + url + ": " + e, e);
    }
    return this;
  }
}
