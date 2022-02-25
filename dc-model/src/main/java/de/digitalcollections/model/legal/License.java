package de.digitalcollections.model.legal;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.text.LocalizedText;
import java.net.URL;

/**
 * License model/description containing all relevant metadata of a license that can be used to
 * specify the license under which an object is available or distributed.
 */
public class License extends UniqueObject {

  private String acronym;
  private LocalizedText label;
  private URL url;

  public License() {}

  public License(String acronym, LocalizedText label, URL url) {
    this.acronym = acronym;
    this.label = label;
    this.url = url;
  }

  /**
   * @return the (language independent/english) acronym for this license, e.g. "CC0 1.0" for "Public
   *     Domain" or "CC BY-NC-SA 3.0"
   */
  public String getAcronym() {
    return acronym;
  }

  /**
   * @return multilingual license title, e.g. "URHEBERRECHTSSCHUTZ - NICHT KOMMERZIELLE NUTZUNG
   *     GESTATTET", "IN COPYRIGHT - NON-COMMERCIAL USE PERMITTED"
   */
  public LocalizedText getLabel() {
    return label;
  }

  /**
   * @return the url to the official public accessible documentation/specification of the license,
   *     e.g. "http://rightsstatements.org/vocab/InC-NC/1.0/"
   */
  public URL getUrl() {
    return url;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "License{"
        + "created=" + created
        + ", lastModified=" + lastModified
        + ", uuid=" + uuid
        + ", acronym='" + acronym + '\''
        + ", label=" + label
        + ", url=" + url
        + '}';
  }
}
