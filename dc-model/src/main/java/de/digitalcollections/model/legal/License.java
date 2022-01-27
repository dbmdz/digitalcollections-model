package de.digitalcollections.model.legal;

import de.digitalcollections.model.text.LocalizedText;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * License model/description containing all relevant metadata of a license that can be used to
 * specify the license under which an object is available or distributed.
 */
public class License {

  private String acronym;
  private LocalDateTime created;
  private LocalizedText label;
  private LocalDateTime lastModified;
  private URL url;
  private UUID uuid;

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

  /** @return date of creation of this license description */
  public LocalDateTime getCreated() {
    return created;
  }

  /**
   * @return multilingual license title, e.g. "URHEBERRECHTSSCHUTZ - NICHT KOMMERZIELLE NUTZUNG
   *     GESTATTET", "IN COPYRIGHT - NON-COMMERCIAL USE PERMITTED"
   */
  public LocalizedText getLabel() {
    return label;
  }

  public LocalDateTime getLastModified() {
    return lastModified;
  }

  /**
   * @return the url to the official public accessible documentation/specification of the license,
   *     e.g. "http://rightsstatements.org/vocab/InC-NC/1.0/"
   */
  public URL getUrl() {
    return url;
  }

  /** @return unique identifier / license key within the system */
  public UUID getUuid() {
    return uuid;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
