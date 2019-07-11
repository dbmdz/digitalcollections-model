package de.digitalcollections.model.impl.legal;

import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.api.legal.License;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class LicenseImpl implements License {

  private String acronym;
  private LocalDateTime created;
  private LocalizedText label;
  private LocalDateTime lastModified;
  private List<ImageFileResource> symbolImages;
  private URL url;
  private UUID uuid;

  @Override
  public String getAcronym() {
    return acronym;
  }

  @Override
  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  @Override
  public LocalDateTime getCreated() {
    return created;
  }

  @Override
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  @Override
  public LocalizedText getLabel() {
    return label;
  }

  @Override
  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  @Override
  public LocalDateTime getLastModified() {
    return lastModified;
  }

  @Override
  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  @Override
  public List<ImageFileResource> getSymbolImages() {
    return symbolImages;
  }

  @Override
  public void setSymbolImages(List<ImageFileResource> symbolImages) {
    this.symbolImages = symbolImages;
  }

  @Override
  public URL getUrl() {
    return url;
  }

  @Override
  public void setUrl(URL url) {
    this.url = url;
  }

  @Override
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

}
