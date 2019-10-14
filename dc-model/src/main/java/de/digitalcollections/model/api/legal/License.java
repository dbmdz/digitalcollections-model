package de.digitalcollections.model.api.legal;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * License model/description containing all relevant metadata of a license that can be used to
 * specify the license under which an object is available or distributed.
 */
public interface License {

  /**
   * @return the (language independent/english) acronym for this license, e.g. "CC0 1.0" for "Public
   *     Domain" or "CC BY-NC-SA 3.0"
   */
  String getAcronym();

  void setAcronym(String acronym);

  /** @return date of creation of this license description */
  LocalDateTime getCreated();

  void setCreated(LocalDateTime created);

  /**
   * @return multilingual license title, e.g. "URHEBERRECHTSSCHUTZ - NICHT KOMMERZIELLE NUTZUNG
   *     GESTATTET", "IN COPYRIGHT - NON-COMMERCIAL USE PERMITTED"
   */
  LocalizedText getLabel();

  void setLabel(LocalizedText label);

  LocalDateTime getLastModified();

  void setLastModified(LocalDateTime lastModified);

  /**
   * @return (downloaded, locally managed ImageFileResource) list of symbol images representing the
   *     license, e.g. like downloaded image https://licensebuttons.net/l/by-nc-sa/4.0/88x31.png. A
   *     list because different sized may be available, e.g. compact one
   *     https://licensebuttons.net/l/by-nc-sa/4.0/80x15.png. Client can choose of list for example
   *     by minimal height...
   */
  List<ImageFileResource> getSymbolImages();

  void setSymbolImages(List<ImageFileResource> symbolImages);

  /**
   * @return the url to the official public accessible documentation/specification of the license,
   *     e.g. "http://rightsstatements.org/vocab/InC-NC/1.0/"
   */
  URL getUrl();

  void setUrl(URL url);

  /** @return unique identifier / license key within the system */
  UUID getUuid();

  void setUuid(UUID uuid);
}
